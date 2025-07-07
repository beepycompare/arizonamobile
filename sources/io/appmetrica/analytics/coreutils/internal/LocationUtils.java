package io.appmetrica.analytics.coreutils.internal;

import android.location.Location;
import android.os.Parcel;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\b"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/LocationUtils;", "", "Landroid/location/Location;", FirebaseAnalytics.Param.LOCATION, "", "locationToBytes", "locationBytes", "bytesToLocation", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class LocationUtils {
    public static final LocationUtils INSTANCE = new LocationUtils();

    private LocationUtils() {
    }

    @JvmStatic
    public static final Location bytesToLocation(byte[] bArr) {
        if (bArr != null) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                Location location = (Location) obtain.readValue(Location.class.getClassLoader());
                obtain.recycle();
                return location;
            } catch (Throwable unused) {
                obtain.recycle();
                return null;
            }
        }
        return null;
    }

    @JvmStatic
    public static final byte[] locationToBytes(Location location) {
        if (location != null) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeValue(location);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                return marshall;
            } catch (Throwable unused) {
                obtain.recycle();
                return null;
            }
        }
        return null;
    }
}
