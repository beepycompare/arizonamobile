package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes3.dex */
public abstract class FastJsonResponse {

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    /* loaded from: classes3.dex */
    public interface FieldConverter<I, O> {
        int zaa();

        int zab();

        Object zac(Object obj);

        Object zad(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final Object zaD(Field field, Object obj) {
        return field.zak != null ? field.zaf(obj) : obj;
    }

    private final void zaE(Field field, Object obj) {
        int i = field.zac;
        Object zae = field.zae(obj);
        String str = field.zae;
        switch (i) {
            case 0:
                if (zae != null) {
                    setIntegerInternal(field, str, ((Integer) zae).intValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 1:
                zaf(field, str, (BigInteger) zae);
                return;
            case 2:
                if (zae != null) {
                    setLongInternal(field, str, ((Long) zae).longValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 3:
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + i);
            case 4:
                if (zae != null) {
                    zan(field, str, ((Double) zae).doubleValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 5:
                zab(field, str, (BigDecimal) zae);
                return;
            case 6:
                if (zae != null) {
                    setBooleanInternal(field, str, ((Boolean) zae).booleanValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 7:
                setStringInternal(field, str, (String) zae);
                return;
            case 8:
            case 9:
                if (zae != null) {
                    setDecodedBytesInternal(field, str, (byte[]) zae);
                    return;
                } else {
                    zaG(str);
                    return;
                }
        }
    }

    private static final void zaF(StringBuilder sb, Field field, Object obj) {
        int i = field.zaa;
        if (i == 11) {
            Class cls = field.zag;
            Preconditions.checkNotNull(cls);
            sb.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else if (i == 7) {
            sb.append("\"");
            sb.append(JsonUtils.escapeString((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }

    private static final void zaG(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            Log.e("FastJsonResponse", "Output field (" + str + ") has a null value, but expected a primitive");
        }
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field field, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field field, String str, T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public abstract Map<String, Field<?, ?>> getFieldMappings();

    protected abstract Object getValueObject(String str);

    protected abstract boolean isPrimitiveFieldSet(String str);

    protected void setBooleanInternal(Field<?, ?> field, String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    protected void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    protected void setIntegerInternal(Field<?, ?> field, String str, int i) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    protected void setLongInternal(Field<?, ?> field, String str, long j) {
        throw new UnsupportedOperationException("Long not supported");
    }

    protected void setStringInternal(Field<?, ?> field, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    protected void setStringMapInternal(Field<?, ?> field, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    protected void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object zaD = zaD(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(StringUtils.COMMA);
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (zaD == null) {
                    sb.append(AbstractJsonLexerKt.NULL);
                } else {
                    switch (field.zac) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64Utils.encode((byte[]) zaD));
                            sb.append("\"");
                            continue;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64Utils.encodeUrlSafe((byte[]) zaD));
                            sb.append("\"");
                            continue;
                        case 10:
                            MapUtils.writeStringMapToJson(sb, (HashMap) zaD);
                            continue;
                        default:
                            if (field.zab) {
                                ArrayList arrayList = (ArrayList) zaD;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(StringUtils.COMMA);
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        zaF(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            } else {
                                zaF(sb, field, zaD);
                                continue;
                            }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public final void zaA(Field field, String str) {
        if (field.zak == null) {
            setStringInternal(field, field.zae, str);
        } else {
            zaE(field, str);
        }
    }

    public final void zaB(Field field, Map map) {
        if (field.zak == null) {
            setStringMapInternal(field, field.zae, map);
        } else {
            zaE(field, map);
        }
    }

    public final void zaC(Field field, ArrayList arrayList) {
        if (field.zak == null) {
            setStringsInternal(field, field.zae, arrayList);
        } else {
            zaE(field, arrayList);
        }
    }

    public final void zaa(Field field, BigDecimal bigDecimal) {
        if (field.zak == null) {
            zab(field, field.zae, bigDecimal);
        } else {
            zaE(field, bigDecimal);
        }
    }

    protected void zab(Field field, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(Field field, ArrayList arrayList) {
        if (field.zak == null) {
            zad(field, field.zae, arrayList);
        } else {
            zaE(field, arrayList);
        }
    }

    protected void zad(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(Field field, BigInteger bigInteger) {
        if (field.zak == null) {
            zaf(field, field.zae, bigInteger);
        } else {
            zaE(field, bigInteger);
        }
    }

    protected void zaf(Field field, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(Field field, ArrayList arrayList) {
        if (field.zak == null) {
            zah(field, field.zae, arrayList);
        } else {
            zaE(field, arrayList);
        }
    }

    protected void zah(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(Field field, boolean z) {
        if (field.zak == null) {
            setBooleanInternal(field, field.zae, z);
        } else {
            zaE(field, Boolean.valueOf(z));
        }
    }

    public final void zaj(Field field, ArrayList arrayList) {
        if (field.zak == null) {
            zak(field, field.zae, arrayList);
        } else {
            zaE(field, arrayList);
        }
    }

    protected void zak(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(Field field, byte[] bArr) {
        if (field.zak == null) {
            setDecodedBytesInternal(field, field.zae, bArr);
        } else {
            zaE(field, bArr);
        }
    }

    public final void zam(Field field, double d) {
        if (field.zak == null) {
            zan(field, field.zae, d);
        } else {
            zaE(field, Double.valueOf(d));
        }
    }

    protected void zan(Field field, String str, double d) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(Field field, ArrayList arrayList) {
        if (field.zak == null) {
            zap(field, field.zae, arrayList);
        } else {
            zaE(field, arrayList);
        }
    }

    protected void zap(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(Field field, float f) {
        if (field.zak == null) {
            zar(field, field.zae, f);
        } else {
            zaE(field, Float.valueOf(f));
        }
    }

    protected void zar(Field field, String str, float f) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(Field field, ArrayList arrayList) {
        if (field.zak == null) {
            zat(field, field.zae, arrayList);
        } else {
            zaE(field, arrayList);
        }
    }

    protected void zat(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(Field field, int i) {
        if (field.zak == null) {
            setIntegerInternal(field, field.zae, i);
        } else {
            zaE(field, Integer.valueOf(i));
        }
    }

    public final void zav(Field field, ArrayList arrayList) {
        if (field.zak == null) {
            zaw(field, field.zae, arrayList);
        } else {
            zaE(field, arrayList);
        }
    }

    protected void zaw(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(Field field, long j) {
        if (field.zak == null) {
            setLongInternal(field, field.zae, j);
        } else {
            zaE(field, Long.valueOf(j));
        }
    }

    public final void zay(Field field, ArrayList arrayList) {
        if (field.zak == null) {
            zaz(field, field.zae, arrayList);
        } else {
            zaE(field, arrayList);
        }
    }

    protected void zaz(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    /* loaded from: classes3.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();
        protected final int zaa;
        protected final boolean zab;
        protected final int zac;
        protected final boolean zad;
        protected final String zae;
        protected final int zaf;
        protected final Class zag;
        protected final String zah;
        private final int zai;
        private zan zaj;
        private final FieldConverter zak;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, com.google.android.gms.common.server.converter.zaa zaaVar) {
            this.zai = i;
            this.zaa = i2;
            this.zab = z;
            this.zac = i3;
            this.zad = z2;
            this.zae = str;
            this.zaf = i4;
            if (str2 == null) {
                this.zag = null;
                this.zah = null;
            } else {
                this.zag = SafeParcelResponse.class;
                this.zah = str2;
            }
            if (zaaVar == null) {
                this.zak = null;
            } else {
                this.zak = zaaVar.zab();
            }
        }

        public static Field<byte[], byte[]> forBase64(String str, int i) {
            return new Field<>(8, false, 8, false, str, i, null, null);
        }

        public static Field<Boolean, Boolean> forBoolean(String str, int i) {
            return new Field<>(6, false, 6, false, str, i, null, null);
        }

        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        public static Field<Double, Double> forDouble(String str, int i) {
            return new Field<>(4, false, 4, false, str, i, null, null);
        }

        public static Field<Float, Float> forFloat(String str, int i) {
            return new Field<>(3, false, 3, false, str, i, null, null);
        }

        public static Field<Integer, Integer> forInteger(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        public static Field<Long, Long> forLong(String str, int i) {
            return new Field<>(2, false, 2, false, str, i, null, null);
        }

        public static Field<String, String> forString(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String str, int i) {
            return new Field<>(10, false, 10, false, str, i, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String str, int i) {
            return new Field<>(7, true, 7, true, str, i, null, null);
        }

        public static Field withConverter(String str, int i, FieldConverter<?, ?> fieldConverter, boolean z) {
            fieldConverter.zaa();
            fieldConverter.zab();
            return new Field(7, z, 0, false, str, i, null, fieldConverter);
        }

        public int getSafeParcelableFieldId() {
            return this.zaf;
        }

        public final String toString() {
            Objects.ToStringHelper add = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.zai)).add("typeIn", Integer.valueOf(this.zaa)).add("typeInArray", Boolean.valueOf(this.zab)).add("typeOut", Integer.valueOf(this.zac)).add("typeOutArray", Boolean.valueOf(this.zad)).add("outputFieldName", this.zae).add("safeParcelFieldId", Integer.valueOf(this.zaf)).add("concreteTypeName", zag());
            Class cls = this.zag;
            if (cls != null) {
                add.add("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter fieldConverter = this.zak;
            if (fieldConverter != null) {
                add.add("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return add.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int i2 = this.zai;
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, i2);
            SafeParcelWriter.writeInt(parcel, 2, this.zaa);
            SafeParcelWriter.writeBoolean(parcel, 3, this.zab);
            SafeParcelWriter.writeInt(parcel, 4, this.zac);
            SafeParcelWriter.writeBoolean(parcel, 5, this.zad);
            SafeParcelWriter.writeString(parcel, 6, this.zae, false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            SafeParcelWriter.writeString(parcel, 8, zag(), false);
            SafeParcelWriter.writeParcelable(parcel, 9, zaa(), i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        final com.google.android.gms.common.server.converter.zaa zaa() {
            FieldConverter fieldConverter = this.zak;
            if (fieldConverter == null) {
                return null;
            }
            return com.google.android.gms.common.server.converter.zaa.zaa(fieldConverter);
        }

        public final Field zab() {
            return new Field(this.zai, this.zaa, this.zab, this.zac, this.zad, this.zae, this.zaf, this.zah, zaa());
        }

        public final FastJsonResponse zad() throws InstantiationException, IllegalAccessException {
            Preconditions.checkNotNull(this.zag);
            Class cls = this.zag;
            if (cls == SafeParcelResponse.class) {
                Preconditions.checkNotNull(this.zah);
                Preconditions.checkNotNull(this.zaj, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
                return new SafeParcelResponse(this.zaj, this.zah);
            }
            return (FastJsonResponse) cls.newInstance();
        }

        public final Object zae(Object obj) {
            Preconditions.checkNotNull(this.zak);
            return Preconditions.checkNotNull(this.zak.zac(obj));
        }

        public final Object zaf(Object obj) {
            Preconditions.checkNotNull(this.zak);
            return this.zak.zad(obj);
        }

        final String zag() {
            String str = this.zah;
            if (str == null) {
                return null;
            }
            return str;
        }

        public final Map zah() {
            Preconditions.checkNotNull(this.zah);
            Preconditions.checkNotNull(this.zaj);
            return (Map) Preconditions.checkNotNull(this.zaj.zab(this.zah));
        }

        public final void zai(zan zanVar) {
            this.zaj = zanVar;
        }

        public final boolean zaj() {
            return this.zak != null;
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class cls, FieldConverter fieldConverter) {
            this.zai = 1;
            this.zaa = i;
            this.zab = z;
            this.zac = i2;
            this.zad = z2;
            this.zae = str;
            this.zaf = i3;
            this.zag = cls;
            if (cls == null) {
                this.zah = null;
            } else {
                this.zah = cls.getCanonicalName();
            }
            this.zak = fieldConverter;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getFieldValue(Field field) {
        String str = field.zae;
        if (field.zag == null) {
            return getValueObject(str);
        }
        Preconditions.checkState(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", field.zae);
        boolean z = field.zad;
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            return getClass().getMethod("get" + upperCase + substring, new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFieldSet(Field field) {
        if (field.zac == 11) {
            boolean z = field.zad;
            String str = field.zae;
            if (z) {
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            }
            throw new UnsupportedOperationException("Concrete types not supported");
        }
        return isPrimitiveFieldSet(field.zae);
    }
}
