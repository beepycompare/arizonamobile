package kotlin.reflect;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* compiled from: KParameter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001bR\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u00020\u000bX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000fX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u00020\u0013X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R)\u0010\u0015\u001a\u00020\u00138&X§\u0084\br\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KAnnotatedElement;", FirebaseAnalytics.Param.INDEX, "", "getIndex", "()I", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "kind", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "isOptional", "", "()Z", "isVararg", "isVararg$annotations", "()V", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.1", "Kind", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface KParameter extends KAnnotatedElement {

    /* compiled from: KParameter.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void isVararg$annotations() {
        }
    }

    int getIndex();

    Kind getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KParameter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0006\b\u0005\u0012\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/KParameter$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "INSTANCE", "CONTEXT", "Lkotlin/ExperimentalContextParameters;", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Kind {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind INSTANCE = new Kind("INSTANCE", 0);
        public static final Kind CONTEXT = new Kind("CONTEXT", 1);
        public static final Kind EXTENSION_RECEIVER = new Kind("EXTENSION_RECEIVER", 2);
        public static final Kind VALUE = new Kind("VALUE", 3);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{INSTANCE, CONTEXT, EXTENSION_RECEIVER, VALUE};
        }

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        private Kind(String str, int i) {
        }

        static {
            Kind[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
