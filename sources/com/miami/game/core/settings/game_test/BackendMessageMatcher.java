package com.miami.game.core.settings.game_test;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
/* compiled from: GameTestScriptModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0005J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003Jj\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019¨\u0006/"}, d2 = {"Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;", "", "backendId", "", "backendName", "", "subId", "message", "messageContains", "messageRegex", "ignoreCase", "", "matchAny", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getBackendId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackendName", "()Ljava/lang/String;", "getSubId", "getMessage", "getMessageContains", "getMessageRegex", "getIgnoreCase", "()Z", "getMatchAny", "hasCriteria", "getHasCriteria", "matches", "event", "Lcom/miami/game/core/settings/game_test/GameTestBackendEvent;", "describe", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/miami/game/core/settings/game_test/BackendMessageMatcher;", "equals", "other", "hashCode", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackendMessageMatcher {
    private final Integer backendId;
    private final String backendName;
    private final boolean ignoreCase;
    private final boolean matchAny;
    private final String message;
    private final String messageContains;
    private final String messageRegex;
    private final Integer subId;

    public BackendMessageMatcher() {
        this(null, null, null, null, null, null, false, false, 255, null);
    }

    public static /* synthetic */ BackendMessageMatcher copy$default(BackendMessageMatcher backendMessageMatcher, Integer num, String str, Integer num2, String str2, String str3, String str4, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = backendMessageMatcher.backendId;
        }
        if ((i & 2) != 0) {
            str = backendMessageMatcher.backendName;
        }
        if ((i & 4) != 0) {
            num2 = backendMessageMatcher.subId;
        }
        if ((i & 8) != 0) {
            str2 = backendMessageMatcher.message;
        }
        if ((i & 16) != 0) {
            str3 = backendMessageMatcher.messageContains;
        }
        if ((i & 32) != 0) {
            str4 = backendMessageMatcher.messageRegex;
        }
        if ((i & 64) != 0) {
            z = backendMessageMatcher.ignoreCase;
        }
        if ((i & 128) != 0) {
            z2 = backendMessageMatcher.matchAny;
        }
        boolean z3 = z;
        boolean z4 = z2;
        String str5 = str3;
        String str6 = str4;
        return backendMessageMatcher.copy(num, str, num2, str2, str5, str6, z3, z4);
    }

    public final Integer component1() {
        return this.backendId;
    }

    public final String component2() {
        return this.backendName;
    }

    public final Integer component3() {
        return this.subId;
    }

    public final String component4() {
        return this.message;
    }

    public final String component5() {
        return this.messageContains;
    }

    public final String component6() {
        return this.messageRegex;
    }

    public final boolean component7() {
        return this.ignoreCase;
    }

    public final boolean component8() {
        return this.matchAny;
    }

    public final BackendMessageMatcher copy(Integer num, String str, Integer num2, String str2, String str3, String str4, boolean z, boolean z2) {
        return new BackendMessageMatcher(num, str, num2, str2, str3, str4, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackendMessageMatcher) {
            BackendMessageMatcher backendMessageMatcher = (BackendMessageMatcher) obj;
            return Intrinsics.areEqual(this.backendId, backendMessageMatcher.backendId) && Intrinsics.areEqual(this.backendName, backendMessageMatcher.backendName) && Intrinsics.areEqual(this.subId, backendMessageMatcher.subId) && Intrinsics.areEqual(this.message, backendMessageMatcher.message) && Intrinsics.areEqual(this.messageContains, backendMessageMatcher.messageContains) && Intrinsics.areEqual(this.messageRegex, backendMessageMatcher.messageRegex) && this.ignoreCase == backendMessageMatcher.ignoreCase && this.matchAny == backendMessageMatcher.matchAny;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.backendId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.backendName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.subId;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.message;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.messageContains;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.messageRegex;
        return ((((hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + Boolean.hashCode(this.ignoreCase)) * 31) + Boolean.hashCode(this.matchAny);
    }

    public String toString() {
        Integer num = this.backendId;
        String str = this.backendName;
        Integer num2 = this.subId;
        String str2 = this.message;
        String str3 = this.messageContains;
        String str4 = this.messageRegex;
        boolean z = this.ignoreCase;
        return "BackendMessageMatcher(backendId=" + num + ", backendName=" + str + ", subId=" + num2 + ", message=" + str2 + ", messageContains=" + str3 + ", messageRegex=" + str4 + ", ignoreCase=" + z + ", matchAny=" + this.matchAny + ")";
    }

    public BackendMessageMatcher(Integer num, String str, Integer num2, String str2, String str3, String str4, boolean z, boolean z2) {
        this.backendId = num;
        this.backendName = str;
        this.subId = num2;
        this.message = str2;
        this.messageContains = str3;
        this.messageRegex = str4;
        this.ignoreCase = z;
        this.matchAny = z2;
    }

    public /* synthetic */ BackendMessageMatcher(Integer num, String str, Integer num2, String str2, String str3, String str4, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? false : z, (i & 128) != 0 ? false : z2);
    }

    public final Integer getBackendId() {
        return this.backendId;
    }

    public final String getBackendName() {
        return this.backendName;
    }

    public final Integer getSubId() {
        return this.subId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getMessageContains() {
        return this.messageContains;
    }

    public final String getMessageRegex() {
        return this.messageRegex;
    }

    public final boolean getIgnoreCase() {
        return this.ignoreCase;
    }

    public final boolean getMatchAny() {
        return this.matchAny;
    }

    public final boolean getHasCriteria() {
        if (this.backendId == null) {
            String str = this.backendName;
            if ((str == null || StringsKt.isBlank(str)) && this.subId == null && this.message == null) {
                String str2 = this.messageContains;
                if (str2 == null || str2.length() == 0) {
                    String str3 = this.messageRegex;
                    return (str3 == null || str3.length() == 0) ? false : true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public final boolean matches(GameTestBackendEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.matchAny || getHasCriteria()) {
            Integer num = this.backendId;
            if (num != null) {
                int backendId = event.getBackendId();
                if (num == null || num.intValue() != backendId) {
                    return false;
                }
            }
            String str = this.backendName;
            if (str == null || StringsKt.isBlank(str) || StringsKt.equals(this.backendName, event.getBackendName(), true)) {
                Integer num2 = this.subId;
                if (num2 != null) {
                    int subId = event.getSubId();
                    if (num2 == null || num2.intValue() != subId) {
                        return false;
                    }
                }
                String str2 = this.message;
                if (str2 == null || StringsKt.equals(str2, event.getMessage(), this.ignoreCase)) {
                    String str3 = this.messageContains;
                    if (str3 == null || str3.length() == 0 || StringsKt.contains(event.getMessage(), this.messageContains, this.ignoreCase)) {
                        String str4 = this.messageRegex;
                        if (str4 != null && str4.length() != 0) {
                            if (!new Regex(this.messageRegex, this.ignoreCase ? SetsKt.setOf(RegexOption.IGNORE_CASE) : SetsKt.emptySet()).containsMatchIn(event.getMessage())) {
                                return false;
                            }
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final String describe() {
        List createListBuilder = CollectionsKt.createListBuilder();
        if (this.matchAny) {
            createListBuilder.add("any=true");
        }
        Integer num = this.backendId;
        if (num != null) {
            createListBuilder.add("backendId=" + num.intValue());
        }
        String str = this.backendName;
        if (str != null) {
            createListBuilder.add("backendName=" + str);
        }
        Integer num2 = this.subId;
        if (num2 != null) {
            createListBuilder.add("subId=" + num2.intValue());
        }
        String str2 = this.message;
        if (str2 != null) {
            createListBuilder.add("message=" + str2);
        }
        String str3 = this.messageContains;
        if (str3 != null) {
            createListBuilder.add("messageContains=" + str3);
        }
        String str4 = this.messageRegex;
        if (str4 != null) {
            createListBuilder.add("messageRegex=" + str4);
        }
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.build(createListBuilder), null, null, null, 0, null, null, 63, null);
        if (StringsKt.isBlank(joinToString$default)) {
            joinToString$default = "empty matcher";
        }
        return joinToString$default;
    }
}
