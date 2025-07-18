package androidx.privacysandbox.ads.adservices.java.topics;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
/* compiled from: TopicsManagerFutures.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\n"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/topics/TopicsManagerFutures;", "", "()V", "getTopicsAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "request", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "CommonApiJavaImpl", "Companion", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TopicsManagerFutures {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final TopicsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    public abstract ListenableFuture<GetTopicsResponse> getTopicsAsync(GetTopicsRequest getTopicsRequest);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TopicsManagerFutures.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/topics/TopicsManagerFutures$CommonApiJavaImpl;", "Landroidx/privacysandbox/ads/adservices/java/topics/TopicsManagerFutures;", "mTopicsManager", "Landroidx/privacysandbox/ads/adservices/topics/TopicsManager;", "(Landroidx/privacysandbox/ads/adservices/topics/TopicsManager;)V", "getTopicsAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "request", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CommonApiJavaImpl extends TopicsManagerFutures {
        private final TopicsManager mTopicsManager;

        public CommonApiJavaImpl(TopicsManager mTopicsManager) {
            Intrinsics.checkNotNullParameter(mTopicsManager, "mTopicsManager");
            this.mTopicsManager = mTopicsManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures
        public ListenableFuture<GetTopicsResponse> getTopicsAsync(GetTopicsRequest request) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(request, "request");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this, request, null), 3, null);
            return CoroutineAdapterKt.asListenableFuture$default(async$default, null, 1, null);
        }
    }

    /* compiled from: TopicsManagerFutures.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/topics/TopicsManagerFutures$Companion;", "", "()V", "from", "Landroidx/privacysandbox/ads/adservices/java/topics/TopicsManagerFutures;", "context", "Landroid/content/Context;", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TopicsManagerFutures from(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TopicsManager obtain = TopicsManager.Companion.obtain(context);
            return obtain != null ? new CommonApiJavaImpl(obtain) : null;
        }
    }
}
