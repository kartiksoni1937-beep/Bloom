#version 330

// lithium menu frosted glass (GlassK frost elements, the analytic path): the blurred world (Sampler0: a.g.FrostK,
// covering the framebuffer) at this pixel's own screen place, times the vertex colour (its grey darkens it, its alpha
// fades it), inside the shape with exactly the coverage shape_aa.fsh gives the glass body over it, so the frost lines
// up with the body's anti-aliased edge. (Self-contained like vanilla's position_tex_color.fsh: no moj_import.)

layout(std140) uniform DynamicTransforms {
    mat4 ModelViewMat;
    vec4 ColorModulator;
    vec3 ModelOffset;
    mat4 TextureMat;
};

uniform sampler2D Sampler0;

in vec2 edgeQ;
in vec4 fillColor;
flat in vec4 lineColor;
flat in vec3 shapeInfo;
noperspective in vec2 screenUv;

out vec4 fragColor;

float boxCov(float v, vec2 g) {
    float l = length(g);
    if (l < 1e-7) {
        return v < 0.0 ? 1.0 : 0.0;
    }
    float u = -v / l;
    vec2 n = abs(g) / l;
    float hi = max(n.x, n.y);
    float lo = min(n.x, n.y);
    float w1 = 0.5 * (hi + lo);
    float w0 = 0.5 * (hi - lo);
    if (u <= -w1) {
        return 0.0;
    }
    if (u >= w1) {
        return 1.0;
    }
    if (u < -w0) {
        float t = u + w1;
        return t * t / (2.0 * lo * hi);
    }
    if (u > w0) {
        float t = w1 - u;
        return 1.0 - t * t / (2.0 * lo * hi);
    }
    return (u + 0.5 * hi) / hi;
}

void main() {
    vec2 q = edgeQ;
    vec2 qx = dFdx(q);
    vec2 qy = dFdy(q);
    vec4 world = texture(Sampler0, screenUv);
    float cov = 1.0;
    if (shapeInfo.z < 0.5) {
        vec2 gx = vec2(qx.x, qy.x);
        vec2 gy = vec2(qx.y, qy.y);
        float r = shapeInfo.x;
        vec2 k = q + r;
        vec2 mk = max(k, 0.0);
        float len = length(mk);
        float d = len + min(max(k.x, k.y), 0.0) - r;
        vec2 nrm = len > 0.0 ? mk / len : (k.x > k.y ? vec2(1.0, 0.0) : vec2(0.0, 1.0));
        vec2 gd = nrm.x * gx + nrm.y * gy;
        cov = min(boxCov(d, gd), boxCov(q.x, gx) * boxCov(q.y, gy));
    }
    float a = fillColor.a * cov;
    if (a <= 0.0) {
        discard;
    }
    fragColor = vec4(world.rgb * fillColor.rgb, a) * ColorModulator;
}
