package androidx.privacysandbox.ads.adservices.adid;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AdIdManager.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adid/AdIdManager;", "", "()V", "getAdId", "Landroidx/privacysandbox/ads/adservices/adid/AdId;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AdIdManager {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final AdIdManager obtain(Context context) {
        return Companion.obtain(context);
    }

    public abstract Object getAdId(Continuation<? super AdId> continuation);

    /* compiled from: AdIdManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adid/AdIdManager$Companion;", "", "()V", "obtain", "Landroidx/privacysandbox/ads/adservices/adid/AdIdManager;", "context", "Landroid/content/Context;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AdIdManager obtain(final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AdServicesInfo.INSTANCE.adServicesVersion() >= 4) {
                return new AdIdManagerApi33Ext4Impl(context);
            }
            if (AdServicesInfo.INSTANCE.extServicesVersionS() >= 9) {
                return (AdIdManager) BackCompatManager.INSTANCE.getManager(context, "AdIdManager", new Function1<Context, AdIdManagerApi31Ext9Impl>() { // from class: androidx.privacysandbox.ads.adservices.adid.AdIdManager$Companion$obtain$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final AdIdManagerApi31Ext9Impl invoke(Context it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new AdIdManagerApi31Ext9Impl(context);
                    }
                });
            }
            return null;
        }
    }
}
