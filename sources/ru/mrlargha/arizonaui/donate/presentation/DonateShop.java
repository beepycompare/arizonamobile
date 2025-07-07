package ru.mrlargha.arizonaui.donate.presentation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.DonateItemBinding;
import ru.mrlargha.arizonaui.databinding.DonateShopBinding;
import ru.mrlargha.arizonaui.donate.domain.obj.Category;
import ru.mrlargha.arizonaui.donate.domain.obj.DonateItem;
import ru.mrlargha.arizonaui.donate.presentation.adapter.DonateAdapter;
import ru.mrlargha.arizonaui.donate.presentation.adapter.DonateCategoryAdapter;
import ru.mrlargha.arizonaui.donate.presentation.api.DonateApi;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DonateShop.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 62\u00020\u0001:\u000256B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020$H\u0002J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J8\u0010*\u001a\u00020$2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00192\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019H\u0002J\u0016\u0010-\u001a\u00020$2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180\u001bH\u0002J\u0018\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0005H\u0016J\u0010\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\u0005H\u0002J\u000e\u00104\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00190\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00190\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/DonateShop;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "activity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "sendServerEvent", "Lru/mrlargha/commonui/core/IBackendNotifier;", "donate", "Landroid/widget/RelativeLayout;", "donateShopBinding", "Lru/mrlargha/arizonaui/databinding/DonateShopBinding;", "balance", "", "donateAdapter", "Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateAdapter;", "donateCategoryAdapter", "Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateCategoryAdapter;", "retrofit", "Lretrofit2/Retrofit;", "donates", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/donate/domain/obj/DonateItem;", "Lkotlin/collections/ArrayList;", "categoryList", "", "Lru/mrlargha/arizonaui/donate/domain/obj/Category;", "mapFromCDN", "Ljava/util/concurrent/ConcurrentHashMap;", "mapFromServer", "currentCategory", "isFirstOpen", "", "setVisibility", "", "visible", "init", "sendRequest", "api", "Lru/mrlargha/arizonaui/donate/presentation/api/DonateApi;", "concatenatingMaps", "cdnList", "serverList", "addServerMap", "donateItems", "onBackendMessage", "data", "subId", "hoverCurrentCategory", "position", "addBalance", "Spawner", "Companion", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateShop extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private String balance;
    private final List<Category> categoryList;
    private String currentCategory;
    private final RelativeLayout donate;
    private final DonateAdapter donateAdapter;
    private final DonateCategoryAdapter donateCategoryAdapter;
    private final DonateShopBinding donateShopBinding;
    private ArrayList<DonateItem> donates;
    private boolean isFirstOpen;
    private final ConcurrentHashMap<String, ArrayList<DonateItem>> mapFromCDN;
    private final ConcurrentHashMap<String, ArrayList<DonateItem>> mapFromServer;
    private Retrofit retrofit;
    private final IBackendNotifier sendServerEvent;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$3$lambda$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateShop(Activity activity, int i) {
        super(activity, i);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity targetActivity = getTargetActivity();
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.sendServerEvent = (IBackendNotifier) targetActivity;
        View inflate = activity.getLayoutInflater().inflate(R.layout.donate_shop, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        this.donate = relativeLayout;
        DonateShopBinding bind = DonateShopBinding.bind(relativeLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.donateShopBinding = bind;
        this.balance = "0";
        this.donateAdapter = new DonateAdapter();
        this.donateCategoryAdapter = new DonateCategoryAdapter();
        this.donates = new ArrayList<>();
        this.categoryList = CollectionsKt.listOf((Object[]) new Category[]{new Category(FirebaseAnalytics.Param.CURRENCY, "Главная", null, Integer.valueOf(R.drawable.ic_money), true), new Category("action", "Акции", null, Integer.valueOf(R.drawable.ic_action), false, 16, null), new Category("marketplace", "Маркетплейс", null, Integer.valueOf(R.drawable.ic_donate), false, 16, null), new Category("vip", "VIP", null, Integer.valueOf(R.drawable.ic_star), false, 16, null), new Category("rareBoxes", "Боксы", null, Integer.valueOf(R.drawable.ic_box), false, 16, null), new Category("vehicle", "Транспорт", null, Integer.valueOf(R.drawable.ic_car), false, 16, null), new Category("tuning", "Тюнинг", null, Integer.valueOf(R.drawable.ic_tune), false, 16, null), new Category("accessories", "Аксессуары", null, Integer.valueOf(R.drawable.ic_diamond), false, 16, null), new Category("skins", "Скины", null, Integer.valueOf(R.drawable.ic_human), false, 16, null), new Category("roulette", "Рулетки", null, Integer.valueOf(R.drawable.ic_casino), false, 16, null), new Category("dance", "Анимации", null, Integer.valueOf(R.drawable.ic_animation), false, 16, null), new Category("other", "Другое", null, Integer.valueOf(R.drawable.ic_other), false, 16, null), new Category("skill", "Навыки", null, Integer.valueOf(R.drawable.ic_skills), false, 16, null), new Category("rareSecurity", "Охранники", null, Integer.valueOf(R.drawable.ic_security), false, 16, null)});
        this.mapFromCDN = new ConcurrentHashMap<>();
        this.mapFromServer = new ConcurrentHashMap<>();
        this.currentCategory = FirebaseAnalytics.Param.CURRENCY;
        this.isFirstOpen = true;
        SAMPUIElement.addViewToConstraintLayout$default(this, relativeLayout, 0, 0, 6, null);
        setVisibility(false);
        init();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        if (!z) {
            this.isFirstOpen = false;
        }
        super.setVisibility(z);
    }

    private final void init() {
        DonateShopBinding donateShopBinding = this.donateShopBinding;
        donateShopBinding.rcView.setLayoutManager(new GridLayoutManager(this.donate.getContext(), 5));
        donateShopBinding.rcView.setAdapter(this.donateAdapter);
        donateShopBinding.categoryRcView.setLayoutManager(new LinearLayoutManager(this.donate.getContext(), 0, false));
        donateShopBinding.categoryRcView.setAdapter(this.donateCategoryAdapter);
        this.donateShopBinding.donateShop.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.donate.presentation.DonateShop$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateShop.init$lambda$3$lambda$0(view);
            }
        });
        this.donateShopBinding.donatePay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.donate.presentation.DonateShop$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateShop.init$lambda$3$lambda$1(DonateShop.this, view);
            }
        });
        this.donateCategoryAdapter.categoryOnClick(new DonateCategoryAdapter.CategoryOnClickListener() { // from class: ru.mrlargha.arizonaui.donate.presentation.DonateShop$init$1$3
            @Override // ru.mrlargha.arizonaui.donate.presentation.adapter.DonateCategoryAdapter.CategoryOnClickListener
            public void categoryOnClick(int i, View view) {
                List list;
                DonateShopBinding donateShopBinding2;
                List list2;
                DonateAdapter donateAdapter;
                List list3;
                ConcurrentHashMap concurrentHashMap;
                String str;
                ConcurrentHashMap concurrentHashMap2;
                String str2;
                ConcurrentHashMap concurrentHashMap3;
                String str3;
                IBackendNotifier iBackendNotifier;
                List list4;
                Intrinsics.checkNotNullParameter(view, "view");
                list = DonateShop.this.categoryList;
                if (Intrinsics.areEqual(((Category) list.get(i)).getId(), "marketplace")) {
                    iBackendNotifier = DonateShop.this.sendServerEvent;
                    int backendID = DonateShop.this.getBackendID();
                    list4 = DonateShop.this.categoryList;
                    byte[] bytes = ((Category) list4.get(i)).getId().getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    iBackendNotifier.clickedWrapper(backendID, -1, -1, bytes);
                    return;
                }
                DonateShop.this.hoverCurrentCategory(i);
                donateShopBinding2 = DonateShop.this.donateShopBinding;
                TextView textView = donateShopBinding2.categoryChosenTitle;
                list2 = DonateShop.this.categoryList;
                textView.setText(((Category) list2.get(i)).getTitle());
                donateAdapter = DonateShop.this.donateAdapter;
                donateAdapter.clearItems();
                DonateShop donateShop = DonateShop.this;
                list3 = donateShop.categoryList;
                donateShop.currentCategory = ((Category) list3.get(i)).getId();
                concurrentHashMap = DonateShop.this.mapFromCDN;
                str = DonateShop.this.currentCategory;
                ArrayList arrayList = (ArrayList) concurrentHashMap.get(str);
                if (arrayList != null) {
                    DonateShop donateShop2 = DonateShop.this;
                    concurrentHashMap2 = donateShop2.mapFromServer;
                    str2 = donateShop2.currentCategory;
                    if (concurrentHashMap2.get(str2) != null) {
                        concurrentHashMap3 = donateShop2.mapFromServer;
                        str3 = donateShop2.currentCategory;
                        ArrayList arrayList2 = (ArrayList) concurrentHashMap3.get(str3);
                        if (arrayList2 != null) {
                            donateShop2.concatenatingMaps(arrayList, arrayList2);
                            return;
                        }
                        return;
                    }
                    donateShop2.concatenatingMaps(arrayList, new ArrayList());
                }
            }
        });
        this.donateShopBinding.closeDonate.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.donate.presentation.DonateShop$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateShop.init$lambda$3$lambda$2(DonateShop.this, view);
            }
        });
        this.donateAdapter.setOnItemClickListener(new DonateAdapter.OnItemClickListener() { // from class: ru.mrlargha.arizonaui.donate.presentation.DonateShop$init$1$5
            @Override // ru.mrlargha.arizonaui.donate.presentation.adapter.DonateAdapter.OnItemClickListener
            public void onItemClick(int i, DonateItemBinding binding) {
                DonateAdapter donateAdapter;
                Object obj;
                DonateAdapter donateAdapter2;
                DonateAdapter donateAdapter3;
                Intrinsics.checkNotNullParameter(binding, "binding");
                try {
                    donateAdapter = DonateShop.this.donateAdapter;
                    List<DonateItem> actuallyList = donateAdapter.getActuallyList();
                    Iterator<T> it = actuallyList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((DonateItem) obj).getOnClicked()) {
                            break;
                        }
                    }
                    DonateItem donateItem = (DonateItem) obj;
                    if (donateItem != null) {
                        int indexOf = actuallyList.indexOf(donateItem);
                        actuallyList.get(indexOf).setOnClicked(false);
                        donateAdapter3 = DonateShop.this.donateAdapter;
                        donateAdapter3.notifyItemChanged(indexOf, actuallyList.get(indexOf));
                    }
                    actuallyList.get(i).setOnClicked(true);
                    donateAdapter2 = DonateShop.this.donateAdapter;
                    donateAdapter2.notifyItemChanged(i, actuallyList.get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("DonateShop", "onItemClick");
                }
            }
        });
        this.donateAdapter.setOnCurrentItemClickListener(new DonateAdapter.OnCurrentItemListener() { // from class: ru.mrlargha.arizonaui.donate.presentation.DonateShop$init$1$6
            @Override // ru.mrlargha.arizonaui.donate.presentation.adapter.DonateAdapter.OnCurrentItemListener
            public void onCurrentItemClick(int i) {
                DonateAdapter donateAdapter;
                ConcurrentHashMap concurrentHashMap;
                ArrayList arrayList;
                IBackendNotifier iBackendNotifier;
                IBackendNotifier iBackendNotifier2;
                donateAdapter = DonateShop.this.donateAdapter;
                List<DonateItem> actuallyList = donateAdapter.getActuallyList();
                DonateItem donateItem = (DonateItem) CollectionsKt.getOrNull(actuallyList, i);
                if (donateItem != null) {
                    if (donateItem.getDiscount() > 0 || donateItem.getSpecialOffer()) {
                        concurrentHashMap = DonateShop.this.mapFromCDN;
                        ArrayList arrayList2 = (ArrayList) concurrentHashMap.get(actuallyList.get(i).getCategory());
                        if (arrayList2 != null) {
                            DonateShop donateShop = DonateShop.this;
                            donateShop.donates = arrayList2;
                            arrayList = donateShop.donates;
                            ArrayList arrayList3 = new ArrayList();
                            for (Object obj : arrayList) {
                                if (((DonateItem) obj).getCategoryId() == actuallyList.get(i).getCategoryId()) {
                                    arrayList3.add(obj);
                                }
                            }
                            int indexOf = arrayList3.indexOf(actuallyList.get(i));
                            iBackendNotifier = donateShop.sendServerEvent;
                            iBackendNotifier.clickedWrapper(donateShop.getBackendID(), actuallyList.get(i).getCategoryId(), indexOf);
                            System.out.println((Object) ("CATEGORYID " + actuallyList.get(i).getCategoryId() + ", POSITION " + indexOf));
                            return;
                        }
                        return;
                    }
                    for (DonateItem donateItem2 : actuallyList) {
                        String category = donateItem2.getCategory();
                        System.out.println((Object) ("Category: " + category + " Tittle: " + donateItem2.getTitle()));
                    }
                    iBackendNotifier2 = DonateShop.this.sendServerEvent;
                    iBackendNotifier2.clickedWrapper(DonateShop.this.getBackendID(), actuallyList.get(i).getCategoryId(), actuallyList.indexOf(actuallyList.get(i)));
                    int categoryId = actuallyList.get(i).getCategoryId();
                    System.out.println((Object) ("CATEGORYID " + categoryId + ", POSITION " + actuallyList.indexOf(actuallyList.get(i))));
                }
            }
        });
        this.donateCategoryAdapter.addCategoryItem(this.categoryList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$3$lambda$1(DonateShop donateShop, View view) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://arizona-rp.com/shop"));
            if (donateShop.getTargetActivity().getPackageManager().resolveActivity(intent, 65536) != null) {
                donateShop.getTargetActivity().startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$3$lambda$2(DonateShop donateShop, View view) {
        donateShop.setVisibility(false);
        donateShop.getNotifier().requestRemoveUIElement(donateShop);
    }

    private final void sendRequest(DonateApi donateApi) {
        donateApi.getDonateItems(DonateShopKt.getDONATE_URL()).enqueue(new DonateShop$sendRequest$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void concatenatingMaps(ArrayList<DonateItem> arrayList, ArrayList<DonateItem> arrayList2) {
        Object obj;
        if ((arrayList.isEmpty() || !Intrinsics.areEqual(arrayList.get(0).getCategory(), this.currentCategory)) && !Intrinsics.areEqual(this.currentCategory, "action")) {
            return;
        }
        Iterator<DonateItem> it = arrayList2.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            DonateItem next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            DonateItem donateItem = next;
            Iterator<T> it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((DonateItem) obj).getId() == donateItem.getId()) {
                    break;
                }
            }
            DonateItem donateItem2 = (DonateItem) obj;
            if (donateItem2 != null) {
                donateItem2.setCategory(donateItem.getCategory());
                donateItem2.setDiscount(donateItem.getDiscount());
                donateItem2.setText(donateItem.getText());
                donateItem2.setCurrencyType(donateItem.getCurrencyType());
                donateItem2.setImage(donateItem.getImage());
                donateItem2.setTitle(donateItem.getTitle());
                donateItem2.setCategoryId(donateItem.getCategoryId());
                donateItem2.setPrice(donateItem.getPrice());
                donateItem2.setSpecialOffer(donateItem.getSpecialOffer());
                donateItem2.setLimit(donateItem.getLimit());
                donateItem2.setStatus(donateItem.getStatus());
                donateItem2.setUnix(donateItem.getUnix());
            } else {
                arrayList.add(donateItem);
            }
        }
        ArrayList<DonateItem> arrayList3 = arrayList;
        if (arrayList3.size() > 1) {
            CollectionsKt.sortWith(arrayList3, new Comparator() { // from class: ru.mrlargha.arizonaui.donate.presentation.DonateShop$concatenatingMaps$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((DonateItem) t).getId()), Integer.valueOf(((DonateItem) t2).getId()));
                }
            });
        }
        this.donateAdapter.clearItems();
        this.donateAdapter.addItem(arrayList3);
    }

    private final void addServerMap(List<DonateItem> list) {
        ArrayList<DonateItem> arrayList;
        ArrayList<DonateItem> arrayList2;
        for (DonateItem donateItem : list) {
            if (this.mapFromServer.get(donateItem.getCategory()) == null) {
                this.mapFromServer.put(donateItem.getCategory(), new ArrayList<>());
                ArrayList<DonateItem> arrayList3 = this.mapFromServer.get(donateItem.getCategory());
                if (arrayList3 != null) {
                    arrayList3.add(donateItem);
                }
            } else {
                ArrayList<DonateItem> arrayList4 = this.mapFromServer.get(donateItem.getCategory());
                boolean z = true;
                if (arrayList4 != null) {
                    for (DonateItem donateItem2 : arrayList4) {
                        if (donateItem2.getId() == donateItem.getId()) {
                            donateItem2.setCategory(donateItem.getCategory());
                            donateItem2.setDiscount(donateItem.getDiscount());
                            donateItem2.setText(donateItem.getText());
                            donateItem2.setCurrencyType(donateItem.getCurrencyType());
                            donateItem2.setImage(donateItem.getImage());
                            donateItem2.setTitle(donateItem.getTitle());
                            donateItem2.setCategoryId(donateItem.getCategoryId());
                            donateItem2.setPrice(donateItem.getPrice());
                            donateItem2.setSpecialOffer(donateItem.getSpecialOffer());
                            donateItem2.setLimit(donateItem.getLimit());
                            donateItem2.setStatus(donateItem.getStatus());
                            donateItem2.setUnix(donateItem.getUnix());
                            z = false;
                        }
                    }
                }
                if (z && (arrayList2 = this.mapFromServer.get(donateItem.getCategory())) != null) {
                    arrayList2.add(donateItem);
                }
            }
        }
        if (this.isFirstOpen || (arrayList = this.mapFromCDN.get(this.currentCategory)) == null) {
            return;
        }
        if (this.mapFromServer.get(this.currentCategory) != null) {
            ArrayList<DonateItem> arrayList5 = this.mapFromServer.get(this.currentCategory);
            if (arrayList5 != null) {
                concatenatingMaps(arrayList, arrayList5);
                return;
            }
            return;
        }
        concatenatingMaps(arrayList, new ArrayList<>());
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            addBalance(data);
        } else if (i == 1) {
            addServerMap(MapperKt.toListModel(data, DonateItem.class));
        } else if (i == 2 && this.mapFromCDN.isEmpty()) {
            Companion.URLObj uRLObj = (Companion.URLObj) MapperKt.toModel(data, Companion.URLObj.class);
            DonateShopKt.setDONATE_URL(uRLObj.getDonateUrl());
            String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            DonateShopKt.setBASE_URL(resourceUrl + uRLObj.getBaseUrl());
            Retrofit build = new Retrofit.Builder().baseUrl(DonateShopKt.getBASE_URL()).addConverterFactory(GsonConverterFactory.create()).build();
            this.retrofit = build;
            if (build == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retrofit");
                build = null;
            }
            DonateApi donateApi = (DonateApi) build.create(DonateApi.class);
            Intrinsics.checkNotNull(donateApi);
            sendRequest(donateApi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hoverCurrentCategory(int i) {
        for (Category category : this.categoryList) {
            category.setOnClicked(false);
        }
        for (DonateItem donateItem : this.donates) {
            donateItem.setOnClicked(false);
        }
        this.donateCategoryAdapter.notifyDataSetChanged();
        this.categoryList.get(i).setOnClicked(true);
        this.donateCategoryAdapter.notifyItemChanged(i, this.categoryList.get(i));
        Log.e("donate", "donates: " + this.donates);
        DonateAdapter donateAdapter = this.donateAdapter;
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.donates) {
            if (Intrinsics.areEqual(((DonateItem) obj).getCategory(), this.categoryList.get(i).getId())) {
                arrayList.add(obj);
            }
        }
        donateAdapter.addItem(arrayList);
    }

    public final void addBalance(String balance) {
        Intrinsics.checkNotNullParameter(balance, "balance");
        this.balance = balance;
        this.donateShopBinding.tvBalance.setText(balance);
    }

    /* compiled from: DonateShop.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/DonateShop$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new DonateShop(targetActivity, i);
        }
    }

    /* compiled from: DonateShop.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/DonateShop$Companion;", "", "<init>", "()V", "URLObj", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: DonateShop.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/DonateShop$Companion$URLObj;", "", "baseUrl", "", "donateUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getDonateUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class URLObj {
            private final String baseUrl;
            private final String donateUrl;

            public static /* synthetic */ URLObj copy$default(URLObj uRLObj, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = uRLObj.baseUrl;
                }
                if ((i & 2) != 0) {
                    str2 = uRLObj.donateUrl;
                }
                return uRLObj.copy(str, str2);
            }

            public final String component1() {
                return this.baseUrl;
            }

            public final String component2() {
                return this.donateUrl;
            }

            public final URLObj copy(String baseUrl, String donateUrl) {
                Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
                Intrinsics.checkNotNullParameter(donateUrl, "donateUrl");
                return new URLObj(baseUrl, donateUrl);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof URLObj) {
                    URLObj uRLObj = (URLObj) obj;
                    return Intrinsics.areEqual(this.baseUrl, uRLObj.baseUrl) && Intrinsics.areEqual(this.donateUrl, uRLObj.donateUrl);
                }
                return false;
            }

            public int hashCode() {
                return (this.baseUrl.hashCode() * 31) + this.donateUrl.hashCode();
            }

            public String toString() {
                String str = this.baseUrl;
                return "URLObj(baseUrl=" + str + ", donateUrl=" + this.donateUrl + ")";
            }

            public URLObj(String baseUrl, String donateUrl) {
                Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
                Intrinsics.checkNotNullParameter(donateUrl, "donateUrl");
                this.baseUrl = baseUrl;
                this.donateUrl = donateUrl;
            }

            public final String getBaseUrl() {
                return this.baseUrl;
            }

            public final String getDonateUrl() {
                return this.donateUrl;
            }
        }

        private Companion() {
        }
    }
}
