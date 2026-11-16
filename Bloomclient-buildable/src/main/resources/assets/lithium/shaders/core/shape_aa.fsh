#version 330

// lithium menu shapes (GlassK, the analytic path; see shape_aa.vsh for the vertex data). Every edge is anti-aliased
// by its exact pixel coverage: the box filter over the pixel's square, for a straight edge at the pixel's own screen
// angle (the pixel's footprint across the edge is a trapezoid), taken from the edge's signed distance and its screen
// gradient, so the result is right at any GUI scale, any fractional position, any rotation and on a 3D board at any
// angle. A square corner is the product of its two sides' coverages (exact for a box filter); a rounded one the
// distance to its arc. The hairline is the band from the outline to w px outside it, its coverage the difference of
// two such edges: a 1 px line at any sub-pixel position lights pixels that always sum to one pixel of ink, so it never
// breaks into dots or steps. Fill and hairline come from the same fragment: no seam, no halo between them.
// (Self-contained like vanilla's gui.fsh: no moj_import.)

layout(std140) uniform DynamicTransforms {
    mat4 ModelViewMat;
    vec4 ColorModulator;
    vec3 ModelOffset;
    mat4 TextureMat;
};

in vec2 edgeQ;
in vec4 fillColor;
flat in vec4 lineColor;
flat in vec3 shapeInfo;
noperspective in vec2 screenUv;

out vec4 fragColor;

// The part of this pixel's square on the inside (v < 0) of the edge v = 0, where v changes by g (x, y) per pixel.
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
    if (shapeInfo.z > 0.5) {
        if (fillColor.a == 0.0) {
            discard;
        }
        fragColor = fillColor * ColorModulator;
        return;
    }
    // each side's distance changes on screen by (d/dx, d/dy)
    vec2 gx = vec2(qx.x, qy.x);
    vec2 gy = vec2(qx.y, qy.y);
    float r = shapeInfo.x;
    vec2 k = q + r;
    vec2 mk = max(k, 0.0);
    float len = length(mk);
    float d = len + min(max(k.x, k.y), 0.0) - r;
    vec2 nrm = len > 0.0 ? mk / len : (k.x > k.y ? vec2(1.0, 0.0) : vec2(0.0, 1.0));
    vec2 gd = nrm.x * gx + nrm.y * gy;
    float cov = min(boxCov(d, gd), boxCov(q.x, gx) * boxCov(q.y, gy));
    float a = fillColor.a * cov;
    vec3 rgb = fillColor.rgb * a;
    float lw = shapeInfo.y;
    if (lw > 0.0 && lineColor.a > 0.0) {
        float ring = max(boxCov(d - lw * length(gd), gd) - boxCov(d, gd), 0.0);
        float la = lineColor.a * ring;
        rgb += lineColor.rgb * la;
        a += la;
    }
    if (a <= 0.0) {
        discard;
    }
    fragColor = vec4(rgb / a, a) * ColorModulator;
}
