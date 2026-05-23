package io.appmetrica.analytics.gpllibrary.internal;

import android.content.Context;
import android.location.LocationListener;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class GplLibraryWrapper implements IGplLibraryWrapper {
    public static final String FUSED_PROVIDER = "fused";

    /* renamed from: a  reason: collision with root package name */
    private final FusedLocationProviderClient f393a;
    private final LocationListener b;
    private final LocationCallback c;
    private final Looper d;
    private final Executor e;
    private final long f;

    /* loaded from: classes5.dex */
    public static class ClientProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Context f394a;

        ClientProvider(Context context) {
            this.f394a = context;
        }

        final FusedLocationProviderClient a() {
            return LocationServices.getFusedLocationProviderClient(this.f394a);
        }
    }

    /* loaded from: classes5.dex */
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
        FusedLocationProviderClient fusedLocationProviderClient = this.f393a;
        LocationRequest interval = LocationRequest.create().setInterval(this.f);
        int ordinal = priority.ordinal();
        fusedLocationProviderClient.requestLocationUpdates(interval.setPriority(ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? 105 : 100 : 102 : 104), this.c, this.d);
    }

    @Override // io.appmetrica.analytics.gpllibrary.internal.IGplLibraryWrapper
    public void stopLocationUpdates() throws Throwable {
        this.f393a.removeLocationUpdates(this.c);
    }

    @Override // io.appmetrica.analytics.gpllibrary.internal.IGplLibraryWrapper
    public void updateLastKnownLocation() throws Throwable {
        this.f393a.getLastLocation().addOnSuccessListener(this.e, new GplOnSuccessListener(this.b));
    }

    GplLibraryWrapper(ClientProvider clientProvider, LocationListener locationListener, Looper looper, Executor executor, long j) {
        this.f393a = clientProvider.a();
        this.b = locationListener;
        this.d = looper;
        this.e = executor;
        this.f = j;
        this.c = new GplLocationCallback(locationListener);
    }
}
