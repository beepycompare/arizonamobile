package io.appmetrica.analytics.location.impl;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class n implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final p f1191a;

    public n(p pVar) {
        this.f1191a = pVar;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        if (location != null) {
            p pVar = this.f1191a;
            pVar.getClass();
            String provider = location.getProvider();
            t tVar = (t) pVar.e.get(provider);
            if (tVar == null) {
                t tVar2 = new t(pVar.f1193a.f1186a);
                tVar2.c.add(pVar.c);
                for (Consumer consumer : pVar.d) {
                    tVar2.c.add(consumer);
                }
                pVar.e.put(provider, tVar2);
                tVar = tVar2;
            } else {
                tVar.f1195a = pVar.f1193a.f1186a;
            }
            if (tVar.d != null) {
                boolean didTimePassMillis = tVar.b.didTimePassMillis(tVar.e, tVar.f1195a.getUpdateTimeInterval(), "isSavedLocationOutdated");
                boolean z = true;
                boolean z2 = location.distanceTo(tVar.d) > tVar.f1195a.getUpdateDistanceInterval();
                if (tVar.d != null && location.getTime() - tVar.d.getTime() < 0) {
                    z = false;
                }
                if ((!didTimePassMillis && !z2) || !z) {
                    return;
                }
            }
            tVar.d = location;
            tVar.e = System.currentTimeMillis();
            Iterator it = tVar.c.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).consume(location);
            }
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
