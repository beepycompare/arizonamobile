package io.appmetrica.analytics.gpllibrary.internal;

import android.content.Context;
import android.location.LocationListener;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public class GplLibraryWrapper implements IGplLibraryWrapper {
    public static final String FUSED_PROVIDER = "fused";

    /* renamed from: a  reason: collision with root package name */
    private final FusedLocationProviderClient f307a;
    private final LocationListener b;
    private final LocationCallback c;
    private final Looper d;
    private final Executor e;
    private final long f;

    /* renamed from: io.appmetrica.analytics.gpllibrary.internal.GplLibraryWrapper$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f308a;

        static {
            int[] iArr = new int[Priority.values().length];
            f308a = iArr;
            try {
                iArr[Priority.PRIORITY_LOW_POWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f308a[Priority.PRIORITY_BALANCED_POWER_ACCURACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f308a[Priority.PRIORITY_HIGH_ACCURACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class ClientProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Context f309a;

        ClientProvider(Context context) {
            this.f309a = context;
        }

        final FusedLocationProviderClient a() {
            return LocationServices.getFusedLocationProviderClient(this.f309a);
        }
    }

    /* loaded from: classes4.dex */
    public enum Priority {
        PRIORITY_NO_POWER,
        PRIORITY_LOW_POWER,
        PRIORITY_BALANCED_POWER_ACCURACY,
        PRIORITY_HIGH_ACCURACY
    }

    public GplLibraryWrapper(Context context, LocationListener locationListener, Looper looper, Executor executor, long j) throws Throwable {
        this(new ClientProvider(context), locationListener, looper, executor, j);
    }

    @Override // io.appmetrica.analytics.gpllibrary.internal.IGplLibraryWrapper
    public void startLocationUpdates(Priority priority) throws Throwable {
        FusedLocationProviderClient fusedLocationProviderClient = this.f307a;
        LocationRequest interval = LocationRequest.create().setInterval(this.f);
        int i = AnonymousClass1.f308a[priority.ordinal()];
        fusedLocationProviderClient.requestLocationUpdates(interval.setPriority(i != 1 ? i != 2 ? i != 3 ? 105 : 100 : 102 : 104), this.c, this.d);
    }

    @Override // io.appmetrica.analytics.gpllibrary.internal.IGplLibraryWrapper
    public void stopLocationUpdates() throws Throwable {
        this.f307a.removeLocationUpdates(this.c);
    }

    @Override // io.appmetrica.analytics.gpllibrary.internal.IGplLibraryWrapper
    public void updateLastKnownLocation() throws Throwable {
        this.f307a.getLastLocation().addOnSuccessListener(this.e, new GplOnSuccessListener(this.b));
    }

    GplLibraryWrapper(ClientProvider clientProvider, LocationListener locationListener, Looper looper, Executor executor, long j) {
        this.f307a = clientProvider.a();
        this.b = locationListener;
        this.d = looper;
        this.e = executor;
        this.f = j;
        this.c = new GplLocationCallback(locationListener);
    }
}
