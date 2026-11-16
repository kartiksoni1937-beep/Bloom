#version 330

// lithium menu shapes (GlassK, the analytic path): every rounded rect, pill, circle, hairline ring and plate of the
// flat GUI and the 3D boards. A shape is four quads, one per quadrant; each vertex carries
//   Position.xy  its screen position, Position.z its view depth on a 3D board (1 on the flat GUI)
//   Color        the fill colour (a vertical gradient interpolates)
//   UV0          q: how far the vertex lies OUTSIDE the quadrant's two sides, in drawing units (linear across the quad)
//   UV1          the hairline colour, RGBA8 in two 16-bit halves
//   UV2          x: the quadrant's corner radius x 32 (drawing units); y: hairline width x 16 (px) << 2 | mode
// (mode 0 = a shape: coverage from its edges; mode 1 = a plain-colour polygon: shadows, carets, flat rects).
// Scaling x, y and w by the depth leaves the vertex where it is and makes q perspective-correct across a board seen at
// an angle (as glyph3d.vsh does). The GUI's matrices put every GUI vertex exactly on the FAR plane (NDC z = 1); with
// w = the depth, z / w would land a hair either side of 1 and the GPU would depth-clip at random. The GUI has no depth
// test, so z = 0 for every vertex. (Self-contained like vanilla's gui.vsh: no moj_import.)

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
in vec4 Color;
in vec2 UV0;
in ivec2 UV1;
in ivec2 UV2;

out vec2 edgeQ;
out vec4 fillColor;
flat out vec4 lineColor;
flat out vec3 shapeInfo;
noperspective out vec2 screenUv;

void main() {
    float w = max(Position.z, 0.001);
    vec4 p = ProjMat * ModelViewMat * vec4(Position.xy, 0.0, 1.0);
    gl_Position = vec4(p.xy * w, 0.0, p.w * w);
    // the frost's texture covers the framebuffer: its coordinate is the vertex's own place on the screen
    screenUv = p.xy / p.w * 0.5 + 0.5;
    edgeQ = UV0;
    fillColor = Color;
    int s0 = UV1.x & 0xFFFF;
    int s1 = UV1.y & 0xFFFF;
    lineColor = vec4(float(s0 >> 8), float(s0 & 255), float(s1 >> 8), float(s1 & 255)) / 255.0;
    int f = UV2.y & 0xFFFF;
    shapeInfo = vec3(float(UV2.x & 0xFFFF) / 32.0, float(f >> 2) / 16.0, float(f & 3));
}
