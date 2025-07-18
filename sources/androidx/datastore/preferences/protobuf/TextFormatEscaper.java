package androidx.datastore.preferences.protobuf;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class TextFormatEscaper {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface ByteSequence {
        byte byteAt(int offset);

        int size();
    }

    private TextFormatEscaper() {
    }

    static String escapeBytes(ByteSequence input) {
        StringBuilder sb = new StringBuilder(input.size());
        for (int i = 0; i < input.size(); i++) {
            byte byteAt = input.byteAt(i);
            if (byteAt == 34) {
                sb.append("\\\"");
            } else if (byteAt == 39) {
                sb.append("\\'");
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (byteAt >= 32 && byteAt <= 126) {
                            sb.append((char) byteAt);
                            continue;
                        } else {
                            sb.append(AbstractJsonLexerKt.STRING_ESC);
                            sb.append((char) (((byteAt >>> 6) & 3) + 48));
                            sb.append((char) (((byteAt >>> 3) & 7) + 48));
                            sb.append((char) ((byteAt & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String escapeBytes(final ByteString input) {
        return escapeBytes(new ByteSequence() { // from class: androidx.datastore.preferences.protobuf.TextFormatEscaper.1
            @Override // androidx.datastore.preferences.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return ByteString.this.size();
            }

            @Override // androidx.datastore.preferences.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int offset) {
                return ByteString.this.byteAt(offset);
            }
        });
    }

    static String escapeBytes(final byte[] input) {
        return escapeBytes(new ByteSequence() { // from class: androidx.datastore.preferences.protobuf.TextFormatEscaper.2
            @Override // androidx.datastore.preferences.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return input.length;
            }

            @Override // androidx.datastore.preferences.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int offset) {
                return input[offset];
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String escapeText(String input) {
        return escapeBytes(ByteString.copyFromUtf8(input));
    }

    static String escapeDoubleQuotesAndBackslashes(String input) {
        return input.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
