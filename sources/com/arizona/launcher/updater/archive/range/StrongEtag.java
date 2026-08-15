package com.arizona.launcher.updater.archive.range;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveRepresentationFencePolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u000b\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "", "headerValue", "", "<init>", "(Ljava/lang/String;)V", "getHeaderValue", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StrongEtag {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String WEAK_PREFIX = "W/";
    private final String headerValue;

    public /* synthetic */ StrongEtag(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private StrongEtag(String str) {
        this.headerValue = str;
    }

    public final String getHeaderValue() {
        return this.headerValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof StrongEtag) && Intrinsics.areEqual(this.headerValue, ((StrongEtag) obj).headerValue);
    }

    public int hashCode() {
        return this.headerValue.hashCode();
    }

    public String toString() {
        return this.headerValue;
    }

    /* compiled from: ArchiveRepresentationFencePolicy.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/StrongEtag$Companion;", "", "<init>", "()V", "parse", "Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "rawValue", "", "isEtagCharacter", "", "", "WEAK_PREFIX", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isEtagCharacter(char c) {
            if (c != '!') {
                if ('#' > c || c >= 127) {
                    return 128 <= c && c < 256;
                }
                return true;
            }
            return true;
        }

        private Companion() {
        }

        public final StrongEtag parse(String str) {
            String str2;
            if (str != null) {
                String str3 = str;
                int length = str3.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    char charAt = str3.charAt(!z ? i : length);
                    boolean z2 = charAt == ' ' || charAt == '\t';
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                str2 = str3.subSequence(i, length + 1).toString();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            if (str2.length() >= 3 && !StringsKt.startsWith$default(str2, StrongEtag.WEAK_PREFIX, false, 2, (Object) null)) {
                String str4 = str2;
                if (StringsKt.first(str4) == '\"' && StringsKt.last(str4) == '\"') {
                    String substring = str2.substring(1, StringsKt.getLastIndex(str4));
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    String str5 = substring;
                    if (str5.length() != 0) {
                        for (int i2 = 0; i2 < str5.length(); i2++) {
                            if (StrongEtag.Companion.isEtagCharacter(str5.charAt(i2))) {
                            }
                        }
                        return new StrongEtag(str2, null);
                    }
                    return null;
                }
            }
            return null;
        }
    }
}
