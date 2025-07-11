package ru.mrlargha.arizonaui.donate.presentation;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mrlargha.arizonaui.donate.domain.obj.Category;
import ru.mrlargha.arizonaui.donate.domain.obj.DonateItem;
/* compiled from: DonateShop.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J0\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\tH\u0016J$\u0010\n\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"ru/mrlargha/arizonaui/donate/presentation/DonateShop$sendRequest$1", "Lretrofit2/Callback;", "", "Lru/mrlargha/arizonaui/donate/domain/obj/DonateItem;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateShop$sendRequest$1 implements Callback<List<? extends DonateItem>> {
    final /* synthetic */ DonateShop this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DonateShop$sendRequest$1(DonateShop donateShop) {
        this.this$0 = donateShop;
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<List<? extends DonateItem>> call, Response<List<? extends DonateItem>> response) {
        List<Category> list;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        ConcurrentHashMap concurrentHashMap4;
        ConcurrentHashMap concurrentHashMap5;
        ConcurrentHashMap concurrentHashMap6;
        ConcurrentHashMap concurrentHashMap7;
        ConcurrentHashMap concurrentHashMap8;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        List<? extends DonateItem> body = response.body();
        if (body != null) {
            final DonateShop donateShop = this.this$0;
            for (DonateItem donateItem : body) {
                concurrentHashMap = donateShop.mapFromCDN;
                if (concurrentHashMap.get(donateItem.getCategory()) == null) {
                    concurrentHashMap7 = donateShop.mapFromCDN;
                    concurrentHashMap7.put(donateItem.getCategory(), new ArrayList());
                    concurrentHashMap8 = donateShop.mapFromCDN;
                    ArrayList arrayList = (ArrayList) concurrentHashMap8.get(donateItem.getCategory());
                    if (arrayList != null) {
                        arrayList.add(donateItem);
                    }
                } else {
                    concurrentHashMap2 = donateShop.mapFromCDN;
                    ArrayList arrayList2 = (ArrayList) concurrentHashMap2.get(donateItem.getCategory());
                    if (arrayList2 != null) {
                        arrayList2.add(donateItem);
                    }
                }
                concurrentHashMap3 = donateShop.mapFromCDN;
                if (concurrentHashMap3.get("action") == null) {
                    if (donateItem.getDiscount() > 0 || donateItem.getSpecialOffer()) {
                        concurrentHashMap4 = donateShop.mapFromCDN;
                        concurrentHashMap4.put("action", new ArrayList());
                        concurrentHashMap5 = donateShop.mapFromCDN;
                        ArrayList arrayList3 = (ArrayList) concurrentHashMap5.get("action");
                        if (arrayList3 != null) {
                            arrayList3.add(donateItem);
                        }
                    }
                } else if (donateItem.getDiscount() > 0 || donateItem.getSpecialOffer()) {
                    concurrentHashMap6 = donateShop.mapFromCDN;
                    ArrayList arrayList4 = (ArrayList) concurrentHashMap6.get("action");
                    if (arrayList4 != null) {
                        arrayList4.add(donateItem);
                    }
                }
            }
            list = donateShop.categoryList;
            for (Category category : list) {
                if (category.getOnClicked()) {
                    donateShop.currentCategory = category.getId();
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ru.mrlargha.arizonaui.donate.presentation.DonateShop$sendRequest$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            DonateShop$sendRequest$1.onResponse$lambda$5$lambda$4(DonateShop.this);
                        }
                    }, 150L);
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResponse$lambda$5$lambda$4(DonateShop donateShop) {
        ConcurrentHashMap concurrentHashMap;
        String str;
        ConcurrentHashMap concurrentHashMap2;
        String str2;
        ConcurrentHashMap concurrentHashMap3;
        String str3;
        concurrentHashMap = donateShop.mapFromCDN;
        str = donateShop.currentCategory;
        ArrayList arrayList = (ArrayList) concurrentHashMap.get(str);
        if (arrayList != null) {
            concurrentHashMap2 = donateShop.mapFromServer;
            str2 = donateShop.currentCategory;
            if (concurrentHashMap2.get(str2) != null) {
                concurrentHashMap3 = donateShop.mapFromServer;
                str3 = donateShop.currentCategory;
                ArrayList arrayList2 = (ArrayList) concurrentHashMap3.get(str3);
                if (arrayList2 != null) {
                    donateShop.concatenatingMaps(arrayList, arrayList2);
                }
            } else {
                donateShop.concatenatingMaps(arrayList, new ArrayList());
            }
        }
        donateShop.isFirstOpen = false;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<List<? extends DonateItem>> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        this.this$0.setVisibility(false);
        Log.w("DonateShop", "error get donate items");
    }
}
