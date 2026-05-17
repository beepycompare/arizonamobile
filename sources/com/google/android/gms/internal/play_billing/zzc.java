package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.extractor.MpegAudioUtil;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.InAppMessageResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.google.android.billing.IabHelper;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public final class zzc {
    public static final int zza = Runtime.getRuntime().availableProcessors();

    public static int zza(Intent intent, String str) {
        if (intent == null) {
            zzo("ProxyBillingActivity", "Got null intent!");
            return 0;
        }
        return zzq(intent.getExtras(), "ProxyBillingActivity");
    }

    public static int zzb(Bundle bundle, String str) {
        if (bundle == null) {
            zzo(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get(IabHelper.RESPONSE_CODE);
        if (obj == null) {
            zzn(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            zzo(str, "Unexpected type for bundle response code: ".concat(String.valueOf(obj.getClass().getName())));
            return 6;
        }
    }

    public static Bundle zzc(Bundle bundle, String str, String str2, long j) {
        bundle.putString("playBillingLibraryVersion", str);
        if (str2 != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str2);
        }
        bundle.putLong("billingClientSessionId", j);
        return bundle;
    }

    public static Bundle zzd(BillingResult billingResult, zzjd zzjdVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(IabHelper.RESPONSE_CODE, billingResult.getResponseCode());
        bundle.putString("DEBUG_MESSAGE", billingResult.getDebugMessage());
        bundle.putInt("LOG_REASON", zzjdVar.zza());
        return bundle;
    }

    public static Bundle zze(BillingResult billingResult, zzjd zzjdVar, String str) {
        Bundle zzd = zzd(billingResult, zzjdVar);
        if (str != null) {
            zzd.putString("ADDITIONAL_LOG_DETAILS", str);
        }
        return zzd;
    }

    public static Bundle zzf(BillingFlowParams billingFlowParams, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, long j, String str3, long j2) {
        int i;
        Bundle bundle = new Bundle();
        zzc(bundle, str, str2, j);
        bundle.putLong("billingClientTransactionId", j2);
        if (billingFlowParams.zzb() != 0) {
            bundle.putInt("prorationMode", billingFlowParams.zzb());
        }
        if (!TextUtils.isEmpty(billingFlowParams.zze())) {
            bundle.putString("accountId", billingFlowParams.zze());
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzf())) {
            bundle.putString("obfuscatedProfileId", billingFlowParams.zzf());
        }
        if (billingFlowParams.zzt()) {
            bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzh())) {
            bundle.putString("oldSkuPurchaseToken", billingFlowParams.zzh());
        }
        billingFlowParams.zzg();
        if (!TextUtils.isEmpty(null)) {
            billingFlowParams.zzg();
            bundle.putString("oldSkuPurchaseId", null);
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzi())) {
            bundle.putString("originalExternalTransactionId", billingFlowParams.zzi());
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("paymentsPurchaseParams", null);
        }
        if (z && z3) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z2 && z4) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        if (z5 || billingFlowParams.getDeveloperBillingOptionParams() != null) {
            bundle.putBoolean("enableAlternativeBilling", true);
        }
        billingFlowParams.zzc();
        billingFlowParams.zza();
        if (billingFlowParams.getDeveloperBillingOptionParams() != null) {
            if (billingFlowParams.getDeveloperBillingOptionParams().getLinkUri() != null) {
                bundle.putString("developerBillingLinkUri", billingFlowParams.getDeveloperBillingOptionParams().getLinkUri().toString());
            }
            if (billingFlowParams.getDeveloperBillingOptionParams().getLaunchMode() != 0) {
                bundle.putInt("developerBillingLaunchMode", billingFlowParams.getDeveloperBillingOptionParams().getLaunchMode());
            }
            bundle.putInt("developerBillingProgram", billingFlowParams.getDeveloperBillingOptionParams().getBillingProgram());
        }
        ArrayList arrayList = new ArrayList();
        for (BillingFlowParams.ProductDetailsParams productDetailsParams : billingFlowParams.zzk()) {
            if (productDetailsParams.getSubscriptionProductReplacementParams() != null) {
                String productId = productDetailsParams.zza().getProductId();
                BillingFlowParams.ProductDetailsParams.SubscriptionProductReplacementParams subscriptionProductReplacementParams = productDetailsParams.getSubscriptionProductReplacementParams();
                zzdq zza2 = zzdr.zza();
                zzea zza3 = zzeb.zza();
                zza3.zza(zzs(productId, "subs", str3));
                zza2.zza(zza3);
                zzea zza4 = zzeb.zza();
                zza4.zza(zzs(subscriptionProductReplacementParams.getOldProductId(), "subs", str3));
                zza2.zzb(zza4);
                switch (subscriptionProductReplacementParams.getReplacementMode()) {
                    case 1:
                        i = 2;
                        break;
                    case 2:
                        i = 3;
                        break;
                    case 3:
                        i = 4;
                        break;
                    case 4:
                        i = 6;
                        break;
                    case 5:
                        i = 7;
                        break;
                    case 6:
                        i = 8;
                        break;
                    case 7:
                        i = 9;
                        break;
                    default:
                        i = 1;
                        break;
                }
                zza2.zzc(i);
                arrayList.add((zzdr) zza2.zzi());
            }
        }
        if (!arrayList.isEmpty()) {
            zzds zza5 = zzdt.zza();
            zza5.zza(arrayList);
            bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzdt) zza5.zzi()).zzQ());
        }
        return bundle;
    }

    public static Bundle zzg(String str, String str2, ArrayList arrayList, String str3, String str4, zza zzaVar, long j) {
        boolean z;
        Bundle bundle = new Bundle();
        zzc(bundle, str, str2, j);
        bundle.putBoolean("enablePendingPurchases", true);
        bundle.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_MULTIPLE_OFFERS", new ArrayList<>(zzbw.zzm("subs", "inapp")));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_PREORDER_OFFERS", new ArrayList<>(zzbw.zzl("inapp")));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_RENT_OFFERS", new ArrayList<>(zzbw.zzl("inapp")));
        bundle.putBoolean("SHOULD_RETURN_UNFETCHED_PRODUCTS", true);
        z = zzaVar.zza;
        if (z) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        int size = arrayList.size();
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < size; i++) {
            arrayList2.add(null);
            z2 |= !TextUtils.isEmpty(null);
            arrayList4.add(null);
            z3 |= !TextUtils.isEmpty(null);
            if (((QueryProductDetailsParams.Product) arrayList.get(i)).zzb().equals("first_party")) {
                zzbj.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                arrayList3.add(null);
            }
        }
        if (z2) {
            bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList3);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("accountName", null);
        }
        if (z3) {
            bundle.putStringArrayList("SKU_DYNAMIC_PRODUCT_TOKEN_LIST", arrayList4);
        }
        return bundle;
    }

    public static Bundle zzh(String str, String str2, long j) {
        Bundle bundle = new Bundle();
        zzc(bundle, str, str2, j);
        return bundle;
    }

    public static BillingResult zzi(Intent intent, String str) {
        if (intent == null) {
            zzo("BillingHelper", "Got null intent!");
            BillingResult.Builder newBuilder = BillingResult.newBuilder();
            newBuilder.setResponseCode(6);
            newBuilder.setDebugMessage("An internal error occurred.");
            return newBuilder.build();
        }
        BillingResult.Builder newBuilder2 = BillingResult.newBuilder();
        newBuilder2.setResponseCode(zzb(intent.getExtras(), str));
        newBuilder2.setDebugMessage(zzk(intent.getExtras(), str));
        return newBuilder2.build();
    }

    public static InAppMessageResult zzj(Bundle bundle, String str) {
        if (bundle == null) {
            return new InAppMessageResult(0, null);
        }
        return new InAppMessageResult(zzq(bundle, "BillingClient"), bundle.getString("IN_APP_MESSAGE_PURCHASE_TOKEN"));
    }

    public static String zzk(Bundle bundle, String str) {
        if (bundle == null) {
            zzo(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zzn(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            zzo(str, "Unexpected type for debug message: ".concat(String.valueOf(obj.getClass().getName())));
            return "";
        }
    }

    public static String zzl(int i) {
        return zzb.zza(i).toString();
    }

    public static List zzm(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(IabHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST);
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList(IabHelper.RESPONSE_INAPP_SIGNATURE_LIST);
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            Purchase zzr = zzr(bundle.getString(IabHelper.RESPONSE_INAPP_PURCHASE_DATA), bundle.getString(IabHelper.RESPONSE_INAPP_SIGNATURE));
            if (zzr == null) {
                zzn("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(zzr);
            return arrayList;
        }
        int size = stringArrayList.size();
        zzn("BillingHelper", "Found purchase list of " + size + " items");
        for (int i = 0; i < stringArrayList.size() && i < stringArrayList2.size(); i++) {
            Purchase zzr2 = zzr(stringArrayList.get(i), stringArrayList2.get(i));
            if (zzr2 != null) {
                arrayList.add(zzr2);
            }
        }
        return arrayList;
    }

    public static void zzn(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            if (!str2.isEmpty()) {
                int i = MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
                while (!str2.isEmpty() && i > 0) {
                    int min = Math.min(str2.length(), Math.min(4000, i));
                    Log.v(str, str2.substring(0, min));
                    str2 = str2.substring(min);
                    i -= min;
                }
                return;
            }
            Log.v(str, str2);
        }
    }

    public static void zzo(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void zzp(String str, String str2, Throwable th) {
        try {
            if (Log.isLoggable(str, 5)) {
                if (th == null) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, th);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static int zzq(Bundle bundle, String str) {
        if (bundle == null) {
            zzo(str, "Unexpected null bundle received!");
            return 0;
        }
        return bundle.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
    }

    private static Purchase zzr(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return new Purchase(str, str2);
            } catch (JSONException e) {
                zzo("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e.toString()));
                return null;
            }
        }
        zzn("BillingHelper", "Received a null purchase data.");
        return null;
    }

    private static String zzs(String str, String str2, String str3) {
        return "subs:" + str3 + StringUtils.PROCESS_POSTFIX_DELIMITER + str;
    }
}
