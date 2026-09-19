package ru.mrlargha.commonui.core.cache;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.UIElementID;
/* compiled from: UIElementCachePolicy.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB'\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/core/cache/UIElementCachePolicy;", "", "pinnedIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "disposeOnHideIds", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "retentionFor", "Lru/mrlargha/commonui/core/cache/UIElementRetentionPolicy;", TtmlNode.ATTR_ID, "canEvict", "", "reason", "Lru/mrlargha/commonui/core/cache/UIElementEvictionReason;", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UIElementCachePolicy {
    private final Set<UIElementID> disposeOnHideIds;
    private final Set<UIElementID> pinnedIds;
    private static final Companion Companion = new Companion(null);
    private static final Set<UIElementID> DEFAULT_PINNED_IDS = SetsKt.setOf((Object[]) new UIElementID[]{UIElementID.COMMAND_BINDER, UIElementID.HUD, UIElementID.INPUT_LAYOUT, UIElementID.INVENTORY, UIElementID.INVENTORY_SECURITY_SCREEN, UIElementID.INVENTORY_WAREHOUSE, UIElementID.INVENTORY_VEHICLE_SCREEN, UIElementID.INVENTORY_WALLET_SCREEN, UIElementID.VOICE_SETTINGS, UIElementID.VOICE_PLAYERS_SETTINGS, UIElementID.ARIZONA_MOBILE_PHONE, UIElementID.RODINA_MOBILE_PHONE});
    private static final Set<UIElementID> DEFAULT_DISPOSE_ON_HIDE_IDS = SetsKt.setOf((Object[]) new UIElementID[]{UIElementID.AUTHORIZATION, UIElementID.DIALOG, UIElementID.SNACKBAR, UIElementID.STREAM_VIDEO, UIElementID.ARIZONA_BANNERS, UIElementID.RATING, UIElementID.RODINA_ACCS_CERTIFICATE, UIElementID.ARIZONA_PROMO, UIElementID.UNKNOWN});

    /* compiled from: UIElementCachePolicy.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UIElementEvictionReason.values().length];
            try {
                iArr[UIElementEvictionReason.HIDE_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UIElementEvictionReason.CAPACITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UIElementEvictionReason.MEMORY_PRESSURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UIElementEvictionReason.EXPLICIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UIElementEvictionReason.HOST_DESTROY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public UIElementCachePolicy() {
        this(null, null, 3, null);
    }

    public UIElementCachePolicy(Set<? extends UIElementID> pinnedIds, Set<? extends UIElementID> disposeOnHideIds) {
        Intrinsics.checkNotNullParameter(pinnedIds, "pinnedIds");
        Intrinsics.checkNotNullParameter(disposeOnHideIds, "disposeOnHideIds");
        Set<UIElementID> set = CollectionsKt.toSet(pinnedIds);
        this.pinnedIds = set;
        Set<UIElementID> set2 = CollectionsKt.toSet(disposeOnHideIds);
        this.disposeOnHideIds = set2;
        if (!CollectionsKt.intersect(set, set2).isEmpty()) {
            throw new IllegalArgumentException("A UI element cannot be both pinned and disposable on hide".toString());
        }
    }

    public /* synthetic */ UIElementCachePolicy(Set set, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DEFAULT_PINNED_IDS : set, (i & 2) != 0 ? DEFAULT_DISPOSE_ON_HIDE_IDS : set2);
    }

    public final UIElementRetentionPolicy retentionFor(UIElementID id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.pinnedIds.contains(id) ? UIElementRetentionPolicy.PINNED : this.disposeOnHideIds.contains(id) ? UIElementRetentionPolicy.DISPOSE_ON_HIDE : UIElementRetentionPolicy.SESSION_HOTSET;
    }

    public final boolean canEvict(UIElementID id, UIElementEvictionReason reason) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reason, "reason");
        int i = WhenMappings.$EnumSwitchMapping$0[reason.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return retentionFor(id) != UIElementRetentionPolicy.PINNED;
        } else if (i == 4 || i == 5) {
            return true;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: UIElementCachePolicy.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/core/cache/UIElementCachePolicy$Companion;", "", "<init>", "()V", "DEFAULT_PINNED_IDS", "", "Lru/mrlargha/commonui/core/UIElementID;", "getDEFAULT_PINNED_IDS", "()Ljava/util/Set;", "DEFAULT_DISPOSE_ON_HIDE_IDS", "getDEFAULT_DISPOSE_ON_HIDE_IDS", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<UIElementID> getDEFAULT_PINNED_IDS() {
            return UIElementCachePolicy.DEFAULT_PINNED_IDS;
        }

        public final Set<UIElementID> getDEFAULT_DISPOSE_ON_HIDE_IDS() {
            return UIElementCachePolicy.DEFAULT_DISPOSE_ON_HIDE_IDS;
        }
    }
}
