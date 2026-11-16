#version 330

// lithium 3D menu text (GlyphK): position_tex_color, except that Position.z carries the vertex's view depth (1 on
// a screen-facing board). Scaling the clip position's x, y and w by it leaves the vertex exactly where it is and makes
// the rasteriser interpolate the atlas coordinates perspective-correctly across a glyph seen at an angle.
// The GUI's matrices (ortho near 1000 / far 11000, model view z -11000) put every GUI vertex EXACTLY on the far plane
// (NDC z = 1). Vanilla gets away with it (w = 1: z / w is exactly 1); with w = the view depth, the GPU's z / w lands a
// hair either side of 1 per vertex, and the depth clip then cut glyphs in half along their quads' diagonals (seen on an
// Intel Arc B580: whole letters missing, others broken up). The GUI has no depth test, so the depth is free: z = 0, the
// middle of the depth range, for any w. (Self-contained like vanilla's position_tex_color.vsh: no moj_import.)

layout(std140) uniform DynamicTransforms {
    mat4 ModelViewMat;
    vec4 ColorModulator;
    vec3 ModelOffset;
    mat4 TextureMat;
};
layout(std140) uniform Projection {
    mat4 ProjMat;
};

in vec3 Position;
in vec2 UV0;
in vec4 Color;

out vec2 texCoord0;
out vec4 vertexColor;

void main() {
    float w = max(Position.z, 0.001);
    vec4 p = ProjMat * ModelViewMat * vec4(Position.xy, 0.0, 1.0);
    gl_Position = vec4(p.xy * w, 0.0, p.w * w);

    texCoord0 = UV0;
    vertexColor = Color;
}
