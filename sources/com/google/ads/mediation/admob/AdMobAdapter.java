package com.google.ads.mediation.admob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.eu;
import java.util.Date;
import java.util.Set;
/* loaded from: classes3.dex */
public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private AdView i;
    private InterstitialAd j;

    /* loaded from: classes3.dex */
    private static final class a extends AdListener {
        private final AdMobAdapter k;
        private final MediationBannerListener l;

        public a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.k = adMobAdapter;
            this.l = mediationBannerListener;
        }

        public void onAdClosed() {
            this.l.onAdClosed(this.k);
        }

        public void onAdFailedToLoad(int i) {
            this.l.onAdFailedToLoad(this.k, i);
        }

        public void onAdLeftApplication() {
            this.l.onAdLeftApplication(this.k);
        }

        public void onAdLoaded() {
            this.l.onAdLoaded(this.k);
        }

        public void onAdOpened() {
            this.l.onAdClicked(this.k);
            this.l.onAdOpened(this.k);
        }
    }

    /* loaded from: classes3.dex */
    private static final class b extends AdListener {
        private final AdMobAdapter k;
        private final MediationInterstitialListener m;

        public b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.k = adMobAdapter;
            this.m = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.m.onAdClosed(this.k);
        }

        public void onAdFailedToLoad(int i) {
            this.m.onAdFailedToLoad(this.k, i);
        }

        public void onAdLeftApplication() {
            this.m.onAdLeftApplication(this.k);
        }

        public void onAdLoaded() {
            this.m.onAdLoaded(this.k);
        }

        public void onAdOpened() {
            this.m.onAdOpened(this.k);
        }
    }

    private static AdRequest a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String str : keywords) {
                builder.addKeyword(str);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(eu.o(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public View getBannerView() {
        return this.i;
    }

    public void onDestroy() {
        AdView adView = this.i;
        if (adView != null) {
            adView.destroy();
            this.i = null;
        }
        if (this.j != null) {
            this.j = null;
        }
    }

    public void onPause() {
        AdView adView = this.i;
        if (adView != null) {
            adView.pause();
        }
    }

    public void onResume() {
        AdView adView = this.i;
        if (adView != null) {
            adView.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        AdView adView = new AdView(context);
        this.i = adView;
        adView.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.i.setAdUnitId(bundle.getString("pubid"));
        this.i.setAdListener(new a(this, mediationBannerListener));
        this.i.loadAd(a(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        InterstitialAd interstitialAd = new InterstitialAd(context);
        this.j = interstitialAd;
        interstitialAd.setAdUnitId(bundle.getString("pubid"));
        this.j.setAdListener(new b(this, mediationInterstitialListener));
        this.j.loadAd(a(context, mediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.j.show();
    }
}
