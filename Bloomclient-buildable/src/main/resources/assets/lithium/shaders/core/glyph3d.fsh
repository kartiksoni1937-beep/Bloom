#version 330

// lithium 3D menu text (GlyphK / GlyphArt). The atlas holds each glyph's signed distance field: R / G = the
// distance to the outline in 16 bits (0.5 = on the outline, +-SPREAD atlas px), A = the glyph's coverage; all mipmapped
// and sampled trilinear. The edge is the field's zero crossing, anti-aliased over exactly one screen pixel (the field's
// screen-space gradient), so a glyph is crisp at any size or angle. Shown very small (the finer screen axis covers
// MIN_LO..MIN_HI atlas px) it hands over to the mip-filtered coverage, which stays stable where the field's detail is
// finer than a pixel. u >= 2 marks the legibility shadow pass (the same glyph, offset by GlyphK, ink colour).
// (Self-contained like vanilla's position_tex_color.fsh: no moj_import.)

layout(std140) uniform DynamicTransforms {
    mat4 ModelViewMat;
    vec4 ColorModulator;
    vec3 ModelOffset;
    mat4 TextureMat;
};

uniform sampler2D Sampler0;

in vec2 texCoord0;
in vec4 vertexColor;

out vec4 fragColor;

const float SPREAD = 16.0;
const float MIN_LO = 4.0;
const float MIN_HI = 8.0;

void main() {
    vec2 uv = texCoord0;
    float shadow = step(1.5, uv.x);
    uv.x -= 2.0 * shadow;

    vec4 t = texture(Sampler0, uv);
    float d = ((t.r * 65280.0 + t.g * 255.0) / 65535.0 - 0.5) * (2.0 * SPREAD);

    // atlas px per screen px along each screen axis, and the extremes of that stretch over every direction
    vec2 ts = vec2(textureSize(Sampler0, 0));
    vec2 jx = dFdx(uv) * ts;
    vec2 jy = dFdy(uv) * ts;
    float s2 = dot(jx, jx) + dot(jy, jy);
    float dj = abs(jx.x * jy.y - jx.y * jy.x);
    float q = sqrt(max(s2 * s2 - 4.0 * dj * dj, 0.0));
    float smax = sqrt(0.5 * (s2 + q));
    float smin = sqrt(max(0.5 * (s2 - q), 0.0));

    // the field's own screen gradient (atlas px per screen px across the edge), kept within that stretch
    float g = length(vec2(dFdx(d), dFdy(d)));
    g = max(clamp(g, smin, smax), 0.0001);
    float a = clamp(d / g + 0.5, 0.0, 1.0);
    a = mix(a, t.a, clamp((smin - MIN_LO) / (MIN_HI - MIN_LO), 0.0, 1.0));

    vec4 color = vec4(vertexColor.rgb, vertexColor.a * a);
    if (color.a == 0.0) {
        discard;
    }
    fragColor = color * ColorModulator;
}
