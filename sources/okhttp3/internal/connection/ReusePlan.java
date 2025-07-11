package okhttp3.internal.connection;

import com.facebook.widget.FacebookDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RoutePlanner;
/* compiled from: ReusePlan.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\n¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/connection/ReusePlan;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "connection", "Lokhttp3/internal/connection/RealConnection;", "<init>", "(Lokhttp3/internal/connection/RealConnection;)V", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "isReady", "", "()Z", "connectTcp", "", "connectTlsEtc", "handleSuccess", FacebookDialog.COMPLETION_GESTURE_CANCEL, "retry", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReusePlan implements RoutePlanner.Plan {
    private final RealConnection connection;
    private final boolean isReady;

    public ReusePlan(RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.connection = connection;
        this.isReady = true;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: connectTcp  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ RoutePlanner.ConnectResult mo10377connectTcp() {
        return (RoutePlanner.ConnectResult) connectTcp();
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: connectTlsEtc  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ RoutePlanner.ConnectResult mo10378connectTlsEtc() {
        return (RoutePlanner.ConnectResult) connectTlsEtc();
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: retry */
    public /* bridge */ /* synthetic */ RoutePlanner.Plan mo10375retry() {
        return (RoutePlanner.Plan) retry();
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public boolean isReady() {
        return this.isReady;
    }

    public Void connectTcp() {
        throw new IllegalStateException("already connected".toString());
    }

    public Void connectTlsEtc() {
        throw new IllegalStateException("already connected".toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: handleSuccess */
    public RealConnection mo10374handleSuccess() {
        return this.connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    /* renamed from: cancel */
    public Void mo10373cancel() {
        throw new IllegalStateException("unexpected cancel".toString());
    }

    public Void retry() {
        throw new IllegalStateException("unexpected retry".toString());
    }
}
