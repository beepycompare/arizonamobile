package com.google.android.gms.common.server.response;

import android.util.Log;
import androidx.media3.common.C;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.internal.Buffer;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaf = {AbstractJsonLexerKt.UNICODE_ESC, 'l', 'l'};
    private static final char[] zag = {'r', AbstractJsonLexerKt.UNICODE_ESC, 'e'};
    private static final char[] zah = {'r', AbstractJsonLexerKt.UNICODE_ESC, 'e', '\"'};
    private static final char[] zai = {'a', 'l', 's', 'e'};
    private static final char[] zaj = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zak = {'\n'};
    private static final zai zam = new zaa();
    private static final zai zan = new zab();
    private static final zai zao = new zac();
    private static final zai zap = new zad();
    private static final zai zaq = new zae();
    private static final zai zar = new zaf();
    private static final zai zas = new zag();
    private static final zai zat = new zah();
    private final char[] zaa = new char[1];
    private final char[] zab = new char[32];
    private final char[] zac = new char[1024];
    private final StringBuilder zad = new StringBuilder(32);
    private final StringBuilder zae = new StringBuilder(1024);
    private final Stack zal = new Stack();

    /* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
    /* loaded from: classes4.dex */
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    private static final String zaA(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z = false;
        boolean z2 = false;
        loop0: while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                int i = 0;
                while (i < read) {
                    char c = cArr[i];
                    if (!Character.isISOControl(c) || (cArr2 != null && cArr2[0] == c)) {
                        int i2 = i + 1;
                        if (c == '\"') {
                            if (!z) {
                                sb.append(cArr, 0, i);
                                bufferedReader.reset();
                                bufferedReader.skip(i2);
                                return z2 ? JsonUtils.unescapeString(sb.toString()) : sb.toString();
                            }
                        } else if (c == '\\') {
                            z = !z;
                            z2 = true;
                            i = i2;
                        }
                        z = false;
                        i = i2;
                    }
                }
                sb.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
        throw new ParseException("Unexpected control character while reading string");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zai(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        HashMap hashMap;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaj2 = zaj(bufferedReader);
        boolean z = true;
        if (zaj2 != null) {
            while (zaj2 != null) {
                FastJsonResponse.Field<?, ?> field = fieldMappings.get(zaj2);
                if (field == null) {
                    zaj2 = zak(bufferedReader);
                } else {
                    Stack stack = this.zal;
                    stack.push(4);
                    int i = field.zaa;
                    char c = AbstractJsonLexerKt.END_OBJ;
                    switch (i) {
                        case 0:
                            if (field.zab) {
                                fastJsonResponse.zab(field, zam(bufferedReader, zam));
                                break;
                            } else {
                                fastJsonResponse.zaa(field, zab(bufferedReader));
                                break;
                            }
                        case 1:
                            if (field.zab) {
                                fastJsonResponse.zad(field, zam(bufferedReader, zas));
                                break;
                            } else {
                                fastJsonResponse.zac(field, zad(bufferedReader));
                                break;
                            }
                        case 2:
                            if (field.zab) {
                                fastJsonResponse.zaf(field, zam(bufferedReader, zan));
                                break;
                            } else {
                                fastJsonResponse.zae(field, zac(bufferedReader));
                                break;
                            }
                        case 3:
                            if (field.zab) {
                                fastJsonResponse.zah(field, zam(bufferedReader, zao));
                                break;
                            } else {
                                fastJsonResponse.zag(field, zaf(bufferedReader));
                                break;
                            }
                        case 4:
                            if (field.zab) {
                                fastJsonResponse.zaj(field, zam(bufferedReader, zap));
                                break;
                            } else {
                                fastJsonResponse.zai(field, zag(bufferedReader));
                                break;
                            }
                        case 5:
                            if (field.zab) {
                                fastJsonResponse.zal(field, zam(bufferedReader, zat));
                                break;
                            } else {
                                fastJsonResponse.zak(field, zah(bufferedReader));
                                break;
                            }
                        case 6:
                            if (field.zab) {
                                fastJsonResponse.zan(field, zam(bufferedReader, zaq));
                                break;
                            } else {
                                fastJsonResponse.zam(field, zar(bufferedReader, false));
                                break;
                            }
                        case 7:
                            if (field.zab) {
                                fastJsonResponse.zap(field, zam(bufferedReader, zar));
                                break;
                            } else {
                                fastJsonResponse.zao(field, zaa(bufferedReader));
                                break;
                            }
                        case 8:
                            fastJsonResponse.zaq(field, Base64Utils.decode(zan(bufferedReader, this.zac, this.zae, zak)));
                            break;
                        case 9:
                            fastJsonResponse.zaq(field, Base64Utils.decodeUrlSafe(zan(bufferedReader, this.zac, this.zae, zak)));
                            break;
                        case 10:
                            char zaw = zaw(bufferedReader);
                            if (zaw == 'n') {
                                zay(bufferedReader, zaf);
                                hashMap = null;
                            } else if (zaw == '{') {
                                stack.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char zaw2 = zaw(bufferedReader);
                                    if (zaw2 == 0) {
                                        throw new ParseException("Unexpected EOF");
                                    }
                                    if (zaw2 == '\"') {
                                        char[] cArr = this.zab;
                                        StringBuilder sb = this.zad;
                                        String zaA = zaA(bufferedReader, cArr, sb, null);
                                        if (zaw(bufferedReader) == ':') {
                                            if (zaw(bufferedReader) == '\"') {
                                                hashMap.put(zaA, zaA(bufferedReader, cArr, sb, null));
                                                char zaw3 = zaw(bufferedReader);
                                                if (zaw3 == ',') {
                                                    z = true;
                                                    c = AbstractJsonLexerKt.END_OBJ;
                                                } else if (zaw3 == '}') {
                                                    zaz(1);
                                                } else {
                                                    StringBuilder sb2 = new StringBuilder(String.valueOf(zaw3).length() + 47);
                                                    sb2.append("Unexpected character while parsing string map: ");
                                                    sb2.append(zaw3);
                                                    throw new ParseException(sb2.toString());
                                                }
                                            } else {
                                                String.valueOf(zaA);
                                                throw new ParseException("Expected String value for key ".concat(String.valueOf(zaA)));
                                            }
                                        } else {
                                            String.valueOf(zaA);
                                            throw new ParseException("No map value found for key ".concat(String.valueOf(zaA)));
                                        }
                                    } else if (zaw2 == c) {
                                        zaz(z ? 1 : 0);
                                    }
                                }
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse.zar(field, hashMap);
                            break;
                        case 11:
                            if (field.zab) {
                                char zaw4 = zaw(bufferedReader);
                                if (zaw4 == 'n') {
                                    zay(bufferedReader, zaf);
                                    fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, null);
                                    break;
                                } else {
                                    stack.push(5);
                                    if (zaw4 == '[') {
                                        fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                                        break;
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char zaw5 = zaw(bufferedReader);
                                if (zaw5 == 'n') {
                                    zay(bufferedReader, zaf);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.zae, null);
                                    break;
                                } else {
                                    stack.push(1);
                                    if (zaw5 == '{') {
                                        try {
                                            FastJsonResponse zaf2 = field.zaf();
                                            zai(bufferedReader, zaf2);
                                            fastJsonResponse.addConcreteTypeInternal(field, field.zae, zaf2);
                                            break;
                                        } catch (IllegalAccessException e) {
                                            throw new ParseException("Error instantiating inner object", e);
                                        } catch (InstantiationException e2) {
                                            throw new ParseException("Error instantiating inner object", e2);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                        default:
                            int i2 = field.zaa;
                            StringBuilder sb3 = new StringBuilder(String.valueOf(i2).length() + 19);
                            sb3.append("Invalid field type ");
                            sb3.append(i2);
                            throw new ParseException(sb3.toString());
                    }
                    zaz(4);
                    zaz(2);
                    char zaw6 = zaw(bufferedReader);
                    if (zaw6 == ',') {
                        zaj2 = zaj(bufferedReader);
                    } else if (zaw6 != '}') {
                        StringBuilder sb4 = new StringBuilder(String.valueOf(zaw6).length() + 54);
                        sb4.append("Expected end of object or field separator, but found: ");
                        sb4.append(zaw6);
                        throw new ParseException(sb4.toString());
                    } else {
                        zaj2 = null;
                    }
                    z = true;
                }
            }
            zaz(z ? 1 : 0);
            return z;
        }
        zaz(1);
        return false;
    }

    private final String zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        Stack stack = this.zal;
        stack.push(2);
        char zaw = zaw(bufferedReader);
        if (zaw == '\"') {
            stack.push(3);
            String zaA = zaA(bufferedReader, this.zab, this.zad, null);
            zaz(3);
            if (zaw(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        } else if (zaw == ']') {
            zaz(2);
            zaz(1);
            zaz(5);
            return null;
        } else if (zaw == '}') {
            zaz(2);
            return null;
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(zaw).length() + 18);
            sb.append("Unexpected token: ");
            sb.append(zaw);
            throw new ParseException(sb.toString());
        }
    }

    private final String zak(BufferedReader bufferedReader) throws ParseException, IOException {
        bufferedReader.mark(1024);
        char zaw = zaw(bufferedReader);
        int i = 1;
        if (zaw == '\"') {
            char[] cArr = this.zaa;
            if (bufferedReader.read(cArr) != -1) {
                char c = cArr[0];
                boolean z = false;
                do {
                    if (c == '\"') {
                        if (z) {
                            z = true;
                            c = '\"';
                        }
                    }
                    z = c == '\\' ? !z : false;
                    if (bufferedReader.read(cArr) != -1) {
                        c = cArr[0];
                    } else {
                        throw new ParseException("Unexpected EOF while parsing string");
                    }
                } while (!Character.isISOControl(c));
                throw new ParseException("Unexpected control character while reading string");
            }
            throw new ParseException("Unexpected EOF while parsing string");
        } else if (zaw == ',') {
            throw new ParseException("Missing value");
        } else {
            if (zaw == '[') {
                this.zal.push(5);
                bufferedReader.mark(32);
                if (zaw(bufferedReader) == ']') {
                    zaz(5);
                } else {
                    bufferedReader.reset();
                    boolean z2 = false;
                    boolean z3 = false;
                    while (i > 0) {
                        char zaw2 = zaw(bufferedReader);
                        if (zaw2 != 0) {
                            if (Character.isISOControl(zaw2)) {
                                throw new ParseException("Unexpected control character while reading array");
                            }
                            if (zaw2 == '\"') {
                                if (!z3) {
                                    z2 = !z2;
                                }
                                zaw2 = '\"';
                            }
                            if (zaw2 == '[') {
                                if (!z2) {
                                    i++;
                                }
                                zaw2 = '[';
                            }
                            if (zaw2 == ']' && !z2) {
                                i--;
                            }
                            z3 = (zaw2 == '\\' && z2) ? !z3 : false;
                        } else {
                            throw new ParseException("Unexpected EOF while parsing array");
                        }
                    }
                    zaz(5);
                }
            } else if (zaw == '{') {
                this.zal.push(1);
                bufferedReader.mark(32);
                char zaw3 = zaw(bufferedReader);
                if (zaw3 == '}') {
                    zaz(1);
                } else if (zaw3 == '\"') {
                    bufferedReader.reset();
                    zaj(bufferedReader);
                    do {
                    } while (zak(bufferedReader) != null);
                    zaz(1);
                } else {
                    StringBuilder sb = new StringBuilder(String.valueOf(zaw3).length() + 17);
                    sb.append("Unexpected token ");
                    sb.append(zaw3);
                    throw new ParseException(sb.toString());
                }
            } else {
                bufferedReader.reset();
                zax(bufferedReader, this.zac);
            }
        }
        char zaw4 = zaw(bufferedReader);
        if (zaw4 == ',') {
            zaz(2);
            return zaj(bufferedReader);
        } else if (zaw4 == '}') {
            zaz(2);
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder(String.valueOf(zaw4).length() + 17);
            sb2.append("Unexpected token ");
            sb2.append(zaw4);
            throw new ParseException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zal */
    public final String zaa(BufferedReader bufferedReader) throws ParseException, IOException {
        return zan(bufferedReader, this.zab, this.zad, null);
    }

    private final ArrayList zam(BufferedReader bufferedReader, zai zaiVar) throws ParseException, IOException {
        char zaw = zaw(bufferedReader);
        if (zaw == 'n') {
            zay(bufferedReader, zaf);
            return null;
        } else if (zaw != '[') {
            throw new ParseException("Expected start of array");
        } else {
            this.zal.push(5);
            ArrayList arrayList = new ArrayList();
            while (true) {
                bufferedReader.mark(1024);
                char zaw2 = zaw(bufferedReader);
                if (zaw2 == 0) {
                    throw new ParseException("Unexpected EOF");
                }
                if (zaw2 != ',') {
                    if (zaw2 != ']') {
                        bufferedReader.reset();
                        arrayList.add(zaiVar.zaa(this, bufferedReader));
                    } else {
                        zaz(5);
                        return arrayList;
                    }
                }
            }
        }
    }

    private final String zan(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        char zaw = zaw(bufferedReader);
        if (zaw != '\"') {
            if (zaw == 'n') {
                zay(bufferedReader, zaf);
                return null;
            }
            throw new ParseException("Expected string");
        }
        return zaA(bufferedReader, cArr, sb, cArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zao */
    public final int zab(BufferedReader bufferedReader) throws ParseException, IOException {
        int i;
        int i2;
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return 0;
        }
        if (zax > 0) {
            char c = cArr[0];
            int i3 = c == '-' ? Integer.MIN_VALUE : C.RATE_UNSET_INT;
            int i4 = c == '-' ? 1 : 0;
            if (i4 < zax) {
                i2 = i4 + 1;
                int digit = Character.digit(cArr[i4], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                i = -digit;
            } else {
                i = 0;
                i2 = i4;
            }
            while (i2 < zax) {
                int i5 = i2 + 1;
                int digit2 = Character.digit(cArr[i2], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                if (i < -214748364) {
                    throw new ParseException("Number too large");
                }
                int i6 = i * 10;
                if (i6 < i3 + digit2) {
                    throw new ParseException("Number too large");
                }
                i = i6 - digit2;
                i2 = i5;
            }
            if (i4 != 0) {
                if (i2 > 1) {
                    return i;
                }
                throw new ParseException("No digits to parse");
            }
            return -i;
        }
        throw new ParseException("No number to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zap */
    public final long zac(BufferedReader bufferedReader) throws ParseException, IOException {
        long j;
        int i;
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return 0L;
        }
        if (zax > 0) {
            char c = cArr[0];
            long j2 = c == '-' ? Long.MIN_VALUE : C.TIME_UNSET;
            int i2 = c == '-' ? 1 : 0;
            if (i2 < zax) {
                i = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                j = -digit;
            } else {
                j = 0;
                i = i2;
            }
            while (i < zax) {
                int i3 = i + 1;
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                if (j < Buffer.OVERFLOW_ZONE) {
                    throw new ParseException("Number too large");
                }
                long j3 = j * 10;
                long j4 = digit2;
                if (j3 < j2 + j4) {
                    throw new ParseException("Number too large");
                }
                j = j3 - j4;
                i = i3;
            }
            if (i2 != 0) {
                if (i > 1) {
                    return j;
                }
                throw new ParseException("No digits to parse");
            }
            return -j;
        }
        throw new ParseException("No number to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zaq */
    public final BigInteger zad(BufferedReader bufferedReader) throws ParseException, IOException {
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return null;
        }
        return new BigInteger(new String(cArr, 0, zax));
    }

    private final boolean zar(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        char[] cArr;
        char zaw = zaw(bufferedReader);
        if (zaw == '\"') {
            if (z) {
                throw new ParseException("No boolean value found in string");
            }
            return zar(bufferedReader, true);
        } else if (zaw == 'f') {
            if (z) {
                cArr = zaj;
            } else {
                cArr = zai;
            }
            zay(bufferedReader, cArr);
            return false;
        } else if (zaw == 'n') {
            zay(bufferedReader, zaf);
            return false;
        } else if (zaw == 't') {
            zay(bufferedReader, z ? zah : zag);
            return true;
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(zaw).length() + 18);
            sb.append("Unexpected token: ");
            sb.append(zaw);
            throw new ParseException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zas */
    public final float zaf(BufferedReader bufferedReader) throws ParseException, IOException {
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(cArr, 0, zax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zat */
    public final double zag(BufferedReader bufferedReader) throws ParseException, IOException {
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        return zax == 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : Double.parseDouble(new String(cArr, 0, zax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zau */
    public final BigDecimal zah(BufferedReader bufferedReader) throws ParseException, IOException {
        char[] cArr = this.zac;
        int zax = zax(bufferedReader, cArr);
        if (zax == 0) {
            return null;
        }
        return new BigDecimal(new String(cArr, 0, zax));
    }

    private final ArrayList zav(BufferedReader bufferedReader, FastJsonResponse.Field field) throws ParseException, IOException {
        ArrayList arrayList = new ArrayList();
        char zaw = zaw(bufferedReader);
        if (zaw == ']') {
            zaz(5);
            return arrayList;
        } else if (zaw == 'n') {
            zay(bufferedReader, zaf);
            zaz(5);
            return null;
        } else if (zaw == '{') {
            Stack stack = this.zal;
            stack.push(1);
            while (true) {
                try {
                    FastJsonResponse zaf2 = field.zaf();
                    if (!zai(bufferedReader, zaf2)) {
                        return arrayList;
                    }
                    arrayList.add(zaf2);
                    char zaw2 = zaw(bufferedReader);
                    if (zaw2 != ',') {
                        if (zaw2 == ']') {
                            zaz(5);
                            return arrayList;
                        }
                        StringBuilder sb = new StringBuilder(String.valueOf(zaw2).length() + 18);
                        sb.append("Unexpected token: ");
                        sb.append(zaw2);
                        throw new ParseException(sb.toString());
                    } else if (zaw(bufferedReader) == '{') {
                        stack.push(1);
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (IllegalAccessException e) {
                    throw new ParseException("Error instantiating inner object", e);
                } catch (InstantiationException e2) {
                    throw new ParseException("Error instantiating inner object", e2);
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder(String.valueOf(zaw).length() + 18);
            sb2.append("Unexpected token: ");
            sb2.append(zaw);
            throw new ParseException(sb2.toString());
        }
    }

    private final char zaw(BufferedReader bufferedReader) throws ParseException, IOException {
        char[] cArr = this.zaa;
        if (bufferedReader.read(cArr) != -1) {
            while (Character.isWhitespace(cArr[0])) {
                if (bufferedReader.read(cArr) == -1) {
                    return (char) 0;
                }
            }
            return cArr[0];
        }
        return (char) 0;
    }

    private final int zax(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i;
        char zaw = zaw(bufferedReader);
        if (zaw != 0) {
            if (zaw != ',') {
                if (zaw == 'n') {
                    zay(bufferedReader, zaf);
                    return 0;
                }
                bufferedReader.mark(1024);
                if (zaw == '\"') {
                    i = 0;
                    boolean z = false;
                    while (i < 1024 && bufferedReader.read(cArr, i, 1) != -1) {
                        char c = cArr[i];
                        if (Character.isISOControl(c)) {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                        int i2 = i + 1;
                        if (c == '\"') {
                            if (!z) {
                                bufferedReader.reset();
                                bufferedReader.skip(i2);
                                return i;
                            }
                        } else if (c == '\\') {
                            z = !z;
                            i = i2;
                        }
                        z = false;
                        i = i2;
                    }
                } else {
                    cArr[0] = zaw;
                    i = 1;
                    while (i < 1024 && bufferedReader.read(cArr, i, 1) != -1) {
                        char c2 = cArr[i];
                        if (c2 == '}' || c2 == ',' || Character.isWhitespace(c2) || cArr[i] == ']') {
                            bufferedReader.reset();
                            bufferedReader.skip(i - 1);
                            cArr[i] = 0;
                            return i;
                        }
                        i++;
                    }
                }
                if (i == 1024) {
                    throw new ParseException("Absurdly long value");
                }
                throw new ParseException("Unexpected EOF");
            }
            throw new ParseException("Missing value");
        }
        throw new ParseException("Unexpected EOF");
    }

    private final void zay(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i = 0;
        while (true) {
            int length = cArr.length;
            if (i >= length) {
                return;
            }
            char[] cArr2 = this.zab;
            int read = bufferedReader.read(cArr2, 0, length - i);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i2 = 0; i2 < read; i2++) {
                if (cArr[i2 + i] != cArr2[i2]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i += read;
        }
    }

    private final void zaz(int i) throws ParseException {
        Stack stack = this.zal;
        if (stack.isEmpty()) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 35);
            sb.append("Expected state ");
            sb.append(i);
            sb.append(" but had empty stack");
            throw new ParseException(sb.toString());
        }
        int intValue = ((Integer) stack.pop()).intValue();
        if (intValue == i) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 24 + String.valueOf(intValue).length());
        sb2.append("Expected state ");
        sb2.append(i);
        sb2.append(" but had ");
        sb2.append(intValue);
        throw new ParseException(sb2.toString());
    }

    public void parse(InputStream inputStream, T t) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                Stack stack = this.zal;
                stack.push(0);
                char zaw = zaw(bufferedReader);
                if (zaw != 0) {
                    if (zaw == '[') {
                        stack.push(5);
                        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                        if (fieldMappings.size() != 1) {
                            throw new ParseException("Object array response class must have a single Field");
                        }
                        FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                        t.addConcreteTypeArrayInternal(value, value.zae, zav(bufferedReader, value));
                    } else if (zaw == '{') {
                        stack.push(1);
                        zai(bufferedReader, t);
                    } else {
                        StringBuilder sb = new StringBuilder(String.valueOf(zaw).length() + 18);
                        sb.append("Unexpected token: ");
                        sb.append(zaw);
                        throw new ParseException(sb.toString());
                    }
                    zaz(0);
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException unused) {
                        Log.w("FastParser", "Failed to close reader while parsing.");
                        return;
                    }
                }
                throw new ParseException("No data to parse");
            } catch (IOException e) {
                throw new ParseException(e);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zae(BufferedReader bufferedReader, boolean z) {
        return zar(bufferedReader, false);
    }
}
