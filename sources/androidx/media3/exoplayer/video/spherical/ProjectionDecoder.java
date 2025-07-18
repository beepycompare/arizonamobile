package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.spherical.Projection;
import java.util.ArrayList;
import java.util.zip.Inflater;
/* loaded from: classes2.dex */
final class ProjectionDecoder {
    private static final int MAX_COORDINATE_COUNT = 10000;
    private static final int MAX_TRIANGLE_INDICES = 128000;
    private static final int MAX_VERTEX_COUNT = 32000;
    private static final int TYPE_DFL8 = 1684433976;
    private static final int TYPE_MESH = 1835365224;
    private static final int TYPE_MSHP = 1836279920;
    private static final int TYPE_PROJ = 1886547818;
    private static final int TYPE_RAW = 1918990112;
    private static final int TYPE_YTMP = 2037673328;

    private static int decodeZigZag(int i) {
        return (-(i & 1)) ^ (i >> 1);
    }

    private ProjectionDecoder() {
    }

    public static Projection decode(byte[] bArr, int i) {
        ArrayList<Projection.Mesh> arrayList;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        try {
            arrayList = isProj(parsableByteArray) ? parseProj(parsableByteArray) : parseMshp(parsableByteArray);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size != 1) {
            if (size != 2) {
                return null;
            }
            return new Projection(arrayList.get(0), arrayList.get(1), i);
        }
        return new Projection(arrayList.get(0), i);
    }

    private static boolean isProj(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.setPosition(0);
        return readInt == 1886547818;
    }

    private static ArrayList<Projection.Mesh> parseProj(ParsableByteArray parsableByteArray) {
        int readInt;
        parsableByteArray.skipBytes(8);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit && (readInt = parsableByteArray.readInt() + position) > position && readInt <= limit) {
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == TYPE_YTMP || readInt2 == TYPE_MSHP) {
                parsableByteArray.setLimit(readInt);
                return parseMshp(parsableByteArray);
            }
            parsableByteArray.setPosition(readInt);
            position = readInt;
        }
        return null;
    }

    private static ArrayList<Projection.Mesh> parseMshp(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.readUnsignedByte() != 0) {
            return null;
        }
        parsableByteArray.skipBytes(7);
        int readInt = parsableByteArray.readInt();
        if (readInt == TYPE_DFL8) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray();
            Inflater inflater = new Inflater(true);
            try {
                if (!Util.inflate(parsableByteArray, parsableByteArray2, inflater)) {
                    return null;
                }
                inflater.end();
                parsableByteArray = parsableByteArray2;
            } finally {
                inflater.end();
            }
        } else if (readInt != TYPE_RAW) {
            return null;
        }
        return parseRawMshpData(parsableByteArray);
    }

    private static ArrayList<Projection.Mesh> parseRawMshpData(ParsableByteArray parsableByteArray) {
        ArrayList<Projection.Mesh> arrayList = new ArrayList<>();
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit) {
            int readInt = parsableByteArray.readInt() + position;
            if (readInt <= position || readInt > limit) {
                return null;
            }
            if (parsableByteArray.readInt() == TYPE_MESH) {
                Projection.Mesh parseMesh = parseMesh(parsableByteArray);
                if (parseMesh == null) {
                    return null;
                }
                arrayList.add(parseMesh);
            }
            parsableByteArray.setPosition(readInt);
            position = readInt;
        }
        return arrayList;
    }

    private static Projection.Mesh parseMesh(ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        Projection.Mesh mesh = null;
        if (readInt > 10000) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i = 0; i < readInt; i++) {
            fArr[i] = parsableByteArray.readFloat();
        }
        int readInt2 = parsableByteArray.readInt();
        if (readInt2 > MAX_VERTEX_COUNT) {
            return null;
        }
        double d = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(readInt * 2.0d) / log);
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        int i2 = 8;
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        float[] fArr2 = new float[readInt2 * 5];
        int[] iArr = new int[5];
        int i3 = 0;
        int i4 = 0;
        while (i3 < readInt2) {
            Projection.Mesh mesh2 = mesh;
            int i5 = 0;
            while (i5 < 5) {
                int decodeZigZag = iArr[i5] + decodeZigZag(parsableBitArray.readBits(ceil));
                if (decodeZigZag >= readInt || decodeZigZag < 0) {
                    return mesh2;
                }
                fArr2[i4] = fArr[decodeZigZag];
                iArr[i5] = decodeZigZag;
                i5++;
                i4++;
            }
            i3++;
            mesh = mesh2;
        }
        Projection.Mesh mesh3 = mesh;
        parsableBitArray.setPosition((parsableBitArray.getPosition() + 7) & (-8));
        int i6 = 32;
        int readBits = parsableBitArray.readBits(32);
        Projection.SubMesh[] subMeshArr = new Projection.SubMesh[readBits];
        int i7 = 0;
        while (i7 < readBits) {
            int readBits2 = parsableBitArray.readBits(i2);
            int readBits3 = parsableBitArray.readBits(i2);
            int readBits4 = parsableBitArray.readBits(i6);
            if (readBits4 > MAX_TRIANGLE_INDICES) {
                return mesh3;
            }
            int i8 = readBits;
            int ceil2 = (int) Math.ceil(Math.log(readInt2 * d) / log);
            float[] fArr3 = new float[readBits4 * 3];
            float[] fArr4 = new float[readBits4 * 2];
            int i9 = 0;
            int i10 = 0;
            while (i9 < readBits4) {
                int decodeZigZag2 = i10 + decodeZigZag(parsableBitArray.readBits(ceil2));
                if (decodeZigZag2 < 0 || decodeZigZag2 >= readInt2) {
                    return mesh3;
                }
                int i11 = i9 * 3;
                int i12 = decodeZigZag2 * 5;
                fArr3[i11] = fArr2[i12];
                fArr3[i11 + 1] = fArr2[i12 + 1];
                fArr3[i11 + 2] = fArr2[i12 + 2];
                int i13 = i9 * 2;
                fArr4[i13] = fArr2[i12 + 3];
                fArr4[i13 + 1] = fArr2[i12 + 4];
                i9++;
                i10 = decodeZigZag2;
            }
            subMeshArr[i7] = new Projection.SubMesh(readBits2, fArr3, fArr4, readBits3);
            i7++;
            readBits = i8;
            i6 = 32;
            d = 2.0d;
            i2 = 8;
        }
        return new Projection.Mesh(subMeshArr);
    }
}
