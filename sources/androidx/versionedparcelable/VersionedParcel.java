package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    protected abstract void closeField();

    protected abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    protected abstract boolean readBoolean();

    protected abstract Bundle readBundle();

    protected abstract byte[] readByteArray();

    protected abstract CharSequence readCharSequence();

    protected abstract double readDouble();

    protected abstract boolean readField(int i);

    protected abstract float readFloat();

    protected abstract int readInt();

    protected abstract long readLong();

    protected abstract <T extends Parcelable> T readParcelable();

    protected abstract String readString();

    protected abstract IBinder readStrongBinder();

    protected abstract void setOutputField(int i);

    public void setSerializationFlags(boolean z, boolean z2) {
    }

    protected abstract void writeBoolean(boolean z);

    protected abstract void writeBundle(Bundle bundle);

    protected abstract void writeByteArray(byte[] bArr);

    protected abstract void writeByteArray(byte[] bArr, int i, int i2);

    protected abstract void writeCharSequence(CharSequence charSequence);

    protected abstract void writeDouble(double d);

    protected abstract void writeFloat(float f);

    protected abstract void writeInt(int i);

    protected abstract void writeLong(long j);

    protected abstract void writeParcelable(Parcelable parcelable);

    protected abstract void writeString(String str);

    protected abstract void writeStrongBinder(IBinder iBinder);

    protected abstract void writeStrongInterface(IInterface iInterface);

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    public void writeStrongInterface(IInterface iInterface, int i) {
        setOutputField(i);
        writeStrongInterface(iInterface);
    }

    public void writeBundle(Bundle bundle, int i) {
        setOutputField(i);
        writeBundle(bundle);
    }

    public void writeBoolean(boolean z, int i) {
        setOutputField(i);
        writeBoolean(z);
    }

    public void writeByteArray(byte[] bArr, int i) {
        setOutputField(i);
        writeByteArray(bArr);
    }

    public void writeByteArray(byte[] bArr, int i, int i2, int i3) {
        setOutputField(i3);
        writeByteArray(bArr, i, i2);
    }

    public void writeCharSequence(CharSequence charSequence, int i) {
        setOutputField(i);
        writeCharSequence(charSequence);
    }

    public void writeInt(int i, int i2) {
        setOutputField(i2);
        writeInt(i);
    }

    public void writeLong(long j, int i) {
        setOutputField(i);
        writeLong(j);
    }

    public void writeFloat(float f, int i) {
        setOutputField(i);
        writeFloat(f);
    }

    public void writeDouble(double d, int i) {
        setOutputField(i);
        writeDouble(d);
    }

    public void writeString(String str, int i) {
        setOutputField(i);
        writeString(str);
    }

    public void writeStrongBinder(IBinder iBinder, int i) {
        setOutputField(i);
        writeStrongBinder(iBinder);
    }

    public void writeParcelable(Parcelable parcelable, int i) {
        setOutputField(i);
        writeParcelable(parcelable);
    }

    public boolean readBoolean(boolean z, int i) {
        return !readField(i) ? z : readBoolean();
    }

    public int readInt(int i, int i2) {
        return !readField(i2) ? i : readInt();
    }

    public long readLong(long j, int i) {
        return !readField(i) ? j : readLong();
    }

    public float readFloat(float f, int i) {
        return !readField(i) ? f : readFloat();
    }

    public double readDouble(double d, int i) {
        return !readField(i) ? d : readDouble();
    }

    public String readString(String str, int i) {
        return !readField(i) ? str : readString();
    }

    public IBinder readStrongBinder(IBinder iBinder, int i) {
        return !readField(i) ? iBinder : readStrongBinder();
    }

    public byte[] readByteArray(byte[] bArr, int i) {
        return !readField(i) ? bArr : readByteArray();
    }

    public <T extends Parcelable> T readParcelable(T t, int i) {
        return !readField(i) ? t : (T) readParcelable();
    }

    public Bundle readBundle(Bundle bundle, int i) {
        return !readField(i) ? bundle : readBundle();
    }

    public void writeByte(byte b, int i) {
        setOutputField(i);
        writeInt(b);
    }

    public void writeSize(Size size, int i) {
        setOutputField(i);
        writeBoolean(size != null);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    public void writeSizeF(SizeF sizeF, int i) {
        setOutputField(i);
        writeBoolean(sizeF != null);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i) {
        setOutputField(i);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            writeInt(sparseBooleanArray.keyAt(i2));
            writeBoolean(sparseBooleanArray.valueAt(i2));
        }
    }

    public void writeBooleanArray(boolean[] zArr, int i) {
        setOutputField(i);
        writeBooleanArray(zArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeBooleanArray(boolean[] zArr) {
        if (zArr != null) {
            writeInt(zArr.length);
            for (boolean z : zArr) {
                writeInt(z ? 1 : 0);
            }
            return;
        }
        writeInt(-1);
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i) {
        return !readField(i) ? zArr : readBooleanArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean[] readBooleanArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i = 0; i < readInt; i++) {
            zArr[i] = readInt() != 0;
        }
        return zArr;
    }

    public void writeCharArray(char[] cArr, int i) {
        setOutputField(i);
        if (cArr != null) {
            writeInt(cArr.length);
            for (char c : cArr) {
                writeInt(c);
            }
            return;
        }
        writeInt(-1);
    }

    public CharSequence readCharSequence(CharSequence charSequence, int i) {
        return !readField(i) ? charSequence : readCharSequence();
    }

    public char[] readCharArray(char[] cArr, int i) {
        if (readField(i)) {
            int readInt = readInt();
            if (readInt < 0) {
                return null;
            }
            char[] cArr2 = new char[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                cArr2[i2] = (char) readInt();
            }
            return cArr2;
        }
        return cArr;
    }

    public void writeIntArray(int[] iArr, int i) {
        setOutputField(i);
        writeIntArray(iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeIntArray(int[] iArr) {
        if (iArr != null) {
            writeInt(iArr.length);
            for (int i : iArr) {
                writeInt(i);
            }
            return;
        }
        writeInt(-1);
    }

    public int[] readIntArray(int[] iArr, int i) {
        return !readField(i) ? iArr : readIntArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] readIntArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i = 0; i < readInt; i++) {
            iArr[i] = readInt();
        }
        return iArr;
    }

    public void writeLongArray(long[] jArr, int i) {
        setOutputField(i);
        writeLongArray(jArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeLongArray(long[] jArr) {
        if (jArr != null) {
            writeInt(jArr.length);
            for (long j : jArr) {
                writeLong(j);
            }
            return;
        }
        writeInt(-1);
    }

    public long[] readLongArray(long[] jArr, int i) {
        return !readField(i) ? jArr : readLongArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long[] readLongArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i = 0; i < readInt; i++) {
            jArr[i] = readLong();
        }
        return jArr;
    }

    public void writeFloatArray(float[] fArr, int i) {
        setOutputField(i);
        writeFloatArray(fArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeFloatArray(float[] fArr) {
        if (fArr != null) {
            writeInt(fArr.length);
            for (float f : fArr) {
                writeFloat(f);
            }
            return;
        }
        writeInt(-1);
    }

    public float[] readFloatArray(float[] fArr, int i) {
        return !readField(i) ? fArr : readFloatArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] readFloatArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i = 0; i < readInt; i++) {
            fArr[i] = readFloat();
        }
        return fArr;
    }

    public void writeDoubleArray(double[] dArr, int i) {
        setOutputField(i);
        writeDoubleArray(dArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeDoubleArray(double[] dArr) {
        if (dArr != null) {
            writeInt(dArr.length);
            for (double d : dArr) {
                writeDouble(d);
            }
            return;
        }
        writeInt(-1);
    }

    public double[] readDoubleArray(double[] dArr, int i) {
        return !readField(i) ? dArr : readDoubleArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double[] readDoubleArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i = 0; i < readInt; i++) {
            dArr[i] = readDouble();
        }
        return dArr;
    }

    public <T> void writeSet(Set<T> set, int i) {
        writeCollection(set, i);
    }

    public <T> void writeList(List<T> list, int i) {
        writeCollection(list, i);
    }

    public <K, V> void writeMap(Map<K, V> map, int i) {
        setOutputField(i);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        writeCollection(arrayList);
        writeCollection(arrayList2);
    }

    private <T> void writeCollection(Collection<T> collection, int i) {
        setOutputField(i);
        writeCollection(collection);
    }

    private <T> void writeCollection(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
            return;
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    for (T t : collection) {
                        writeVersionedParcelable(t);
                    }
                    return;
                case 2:
                    for (T t2 : collection) {
                        writeParcelable(t2);
                    }
                    return;
                case 3:
                    for (T t3 : collection) {
                        writeSerializable(t3);
                    }
                    return;
                case 4:
                    for (T t4 : collection) {
                        writeString(t4);
                    }
                    return;
                case 5:
                    for (T t5 : collection) {
                        writeStrongBinder(t5);
                    }
                    return;
                case 6:
                default:
                    return;
                case 7:
                    for (T t6 : collection) {
                        writeInt(t6.intValue());
                    }
                    return;
                case 8:
                    for (T t7 : collection) {
                        writeFloat(t7.floatValue());
                    }
                    return;
            }
        }
    }

    public <T> void writeArray(T[] tArr, int i) {
        setOutputField(i);
        writeArray(tArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> void writeArray(T[] tArr) {
        if (tArr == null) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i < length) {
                    writeVersionedParcelable((VersionedParcelable) tArr[i]);
                    i++;
                }
            } else if (type == 2) {
                while (i < length) {
                    writeParcelable((Parcelable) tArr[i]);
                    i++;
                }
            } else if (type == 3) {
                while (i < length) {
                    writeSerializable((Serializable) tArr[i]);
                    i++;
                }
            } else if (type == 4) {
                while (i < length) {
                    writeString((String) tArr[i]);
                    i++;
                }
            } else if (type != 5) {
            } else {
                while (i < length) {
                    writeStrongBinder((IBinder) tArr[i]);
                    i++;
                }
            }
        }
    }

    private <T> int getType(T t) {
        if (t instanceof String) {
            return 4;
        }
        if (t instanceof Parcelable) {
            return 2;
        }
        if (t instanceof VersionedParcelable) {
            return 1;
        }
        if (t instanceof Serializable) {
            return 3;
        }
        if (t instanceof IBinder) {
            return 5;
        }
        if (t instanceof Integer) {
            return 7;
        }
        if (t instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t.getClass().getName() + " cannot be VersionedParcelled");
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i) {
        setOutputField(i);
        writeVersionedParcelable(versionedParcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel createSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, createSubParcel);
        createSubParcel.closeField();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    public void writeSerializable(Serializable serializable, int i) {
        setOutputField(i);
        writeSerializable(serializable);
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString(null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e);
        }
    }

    public void writeException(Exception exc, int i) {
        int i2;
        setOutputField(i);
        if (exc == null) {
            writeNoException();
            return;
        }
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i2 = -9;
        } else if (exc instanceof SecurityException) {
            i2 = -1;
        } else if (exc instanceof BadParcelableException) {
            i2 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i2 = -3;
        } else if (exc instanceof NullPointerException) {
            i2 = -4;
        } else if (exc instanceof IllegalStateException) {
            i2 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i2 = -6;
        } else {
            i2 = exc instanceof UnsupportedOperationException ? -7 : 0;
        }
        writeInt(i2);
        if (i2 == 0) {
            if (exc instanceof RuntimeException) {
                throw ((RuntimeException) exc);
            }
            throw new RuntimeException(exc);
        }
        writeString(exc.getMessage());
        if (i2 != -9) {
            return;
        }
        writeParcelable((Parcelable) exc);
    }

    protected void writeNoException() {
        writeInt(0);
    }

    public Exception readException(Exception exc, int i) {
        int readExceptionCode;
        return (readField(i) && (readExceptionCode = readExceptionCode()) != 0) ? readException(readExceptionCode, readString()) : exc;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private Exception readException(int i, String str) {
        return createException(i, str);
    }

    protected static Throwable getRootCause(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private Exception createException(int i, String str) {
        switch (i) {
            case -9:
                return (Exception) readParcelable();
            case SplitInstallErrorCode.INCOMPATIBLE_WITH_EXISTING_SESSION /* -8 */:
            default:
                return new RuntimeException("Unknown exception code: " + i + " msg " + str);
            case -7:
                return new UnsupportedOperationException(str);
            case -6:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    public byte readByte(byte b, int i) {
        return !readField(i) ? b : (byte) (readInt() & 255);
    }

    public Size readSize(Size size, int i) {
        if (readField(i)) {
            if (readBoolean()) {
                return new Size(readInt(), readInt());
            }
            return null;
        }
        return size;
    }

    public SizeF readSizeF(SizeF sizeF, int i) {
        if (readField(i)) {
            if (readBoolean()) {
                return new SizeF(readFloat(), readFloat());
            }
            return null;
        }
        return sizeF;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i) {
        if (readField(i)) {
            int readInt = readInt();
            if (readInt < 0) {
                return null;
            }
            SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                sparseBooleanArray2.put(readInt(), readBoolean());
            }
            return sparseBooleanArray2;
        }
        return sparseBooleanArray;
    }

    public <T> Set<T> readSet(Set<T> set, int i) {
        return !readField(i) ? set : (Set) readCollection(new ArraySet());
    }

    public <T> List<T> readList(List<T> list, int i) {
        return !readField(i) ? list : (List) readCollection(new ArrayList());
    }

    private <T, S extends Collection<T>> S readCollection(S s) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    s.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    s.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    s.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    s.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    s.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> map, int i) {
        if (readField(i)) {
            int readInt = readInt();
            if (readInt < 0) {
                return null;
            }
            ArrayMap arrayMap = new ArrayMap();
            if (readInt != 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                readCollection(arrayList);
                readCollection(arrayList2);
                for (int i2 = 0; i2 < readInt; i2++) {
                    arrayMap.put(arrayList.get(i2), arrayList2.get(i2));
                }
            }
            return arrayMap;
        }
        return map;
    }

    public <T> T[] readArray(T[] tArr, int i) {
        return !readField(i) ? tArr : (T[]) readArray(tArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T[] readArray(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t, int i) {
        return !readField(i) ? t : (T) readVersionedParcelable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return (T) readFromParcel(readString, createSubParcel());
    }

    protected Serializable readSerializable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) { // from class: androidx.versionedparcelable.VersionedParcel.1
                @Override // java.io.ObjectInputStream
                protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    return cls != null ? cls : super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + readString + ")", e);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + readString + ")", e2);
        }
    }

    protected <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (T) getReadMethod(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    protected <T extends VersionedParcelable> void writeToParcel(T t, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t.getClass()).invoke(null, t, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    private Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mReadCache.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
            this.mReadCache.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    private Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mWriteCache.get(cls.getName());
        if (method == null) {
            Class findParcelClass = findParcelClass(cls);
            System.currentTimeMillis();
            Method declaredMethod = findParcelClass.getDeclaredMethod("write", cls, VersionedParcel.class);
            this.mWriteCache.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.mParcelizerCache.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    /* loaded from: classes3.dex */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }
}
