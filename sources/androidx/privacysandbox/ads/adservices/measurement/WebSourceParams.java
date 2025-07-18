package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.WebSourceParams;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WebSourceParams.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/WebSourceParams;", "", "registrationUri", "Landroid/net/Uri;", "debugKeyAllowed", "", "(Landroid/net/Uri;Z)V", "getDebugKeyAllowed", "()Z", "getRegistrationUri", "()Landroid/net/Uri;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WebSourceParams {
    public static final Companion Companion = new Companion(null);
    private final boolean debugKeyAllowed;
    private final Uri registrationUri;

    public WebSourceParams(Uri registrationUri, boolean z) {
        Intrinsics.checkNotNullParameter(registrationUri, "registrationUri");
        this.registrationUri = registrationUri;
        this.debugKeyAllowed = z;
    }

    public final boolean getDebugKeyAllowed() {
        return this.debugKeyAllowed;
    }

    public final Uri getRegistrationUri() {
        return this.registrationUri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WebSourceParams) {
            WebSourceParams webSourceParams = (WebSourceParams) obj;
            return Intrinsics.areEqual(this.registrationUri, webSourceParams.registrationUri) && this.debugKeyAllowed == webSourceParams.debugKeyAllowed;
        }
        return false;
    }

    public int hashCode() {
        return (this.registrationUri.hashCode() * 31) + Boolean.hashCode(this.debugKeyAllowed);
    }

    public String toString() {
        return "WebSourceParams { RegistrationUri=" + this.registrationUri + ", DebugKeyAllowed=" + this.debugKeyAllowed + " }";
    }

    /* compiled from: WebSourceParams.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0001¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/WebSourceParams$Companion;", "", "()V", "convertWebSourceParams", "", "Landroid/adservices/measurement/WebSourceParams;", "request", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceParams;", "convertWebSourceParams$ads_adservices_release", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<android.adservices.measurement.WebSourceParams> convertWebSourceParams$ads_adservices_release(List<WebSourceParams> request) {
            Intrinsics.checkNotNullParameter(request, "request");
            ArrayList arrayList = new ArrayList();
            for (WebSourceParams webSourceParams : request) {
                android.adservices.measurement.WebSourceParams build = new WebSourceParams.Builder(webSourceParams.getRegistrationUri()).setDebugKeyAllowed(webSourceParams.getDebugKeyAllowed()).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder(param.registrati…                 .build()");
                arrayList.add(build);
            }
            return arrayList;
        }
    }
}
