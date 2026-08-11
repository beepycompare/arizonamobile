package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.elements.inventory.presentation.UtilKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryElementItemBinding;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryItemBinding;
import ru.mrlargha.feature.mobile.presentation.MobilePHoneSendSubIds;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.MobileRentAccessoryCategoryIcon;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCategoryModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryModelItem;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessorySendItemModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessorySendModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage;
/* compiled from: MobileRentAccessoryMainAdapter.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\"#B\u0081\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012K\u0010\u0006\u001aG\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0007\u0012#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0018J\u001c\u0010\u001b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J\u001c\u0010\u001e\u001a\u00020\u00102\n\u0010\u001f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010 \u001a\u00020\u000eH\u0016J\u0014\u0010!\u001a\u00020\u00102\n\u0010\u001f\u001a\u00060\u0003R\u00020\u0000H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\u0006\u001aG\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryModel;", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter$MainViewHolder;", "parent", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage;", "sendEvent", "Lkotlin/Function3;", "Lru/mrlargha/feature/mobile/presentation/MobilePHoneSendSubIds;", "Lkotlin/ParameterName;", "name", "event", "", "data", "", "id", "", "getCategory", "Lkotlin/Function1;", "categoryId", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", "<init>", "(Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "currentTopBar", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryMainPage$Companion$TopBar;", "setCurrentTopBar", "topBar", "onCreateViewHolder", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onViewRecycled", "MainViewHolder", "Companion", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryMainAdapter extends ListAdapter<MobileRentAccessoryModel, MainViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final MobileRentAccessoryMainAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<MobileRentAccessoryModel>() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(MobileRentAccessoryModel oldItem, MobileRentAccessoryModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(MobileRentAccessoryModel oldItem, MobileRentAccessoryModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }
    };
    private MobileRentAccessoryMainPage.Companion.TopBar currentTopBar;
    private final Function1<Integer, MobileRentAccessoryCategoryModel> getCategory;
    private final RentAccessoryPage parent;
    private final Function3<MobilePHoneSendSubIds, String, Integer, Unit> sendEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MobileRentAccessoryMainAdapter(RentAccessoryPage parent, Function3<? super MobilePHoneSendSubIds, ? super String, ? super Integer, Unit> sendEvent, Function1<? super Integer, MobileRentAccessoryCategoryModel> getCategory) {
        super(diffUtilCallback);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        Intrinsics.checkNotNullParameter(getCategory, "getCategory");
        this.parent = parent;
        this.sendEvent = sendEvent;
        this.getCategory = getCategory;
        this.currentTopBar = MobileRentAccessoryMainPage.Companion.TopBar.ALL;
    }

    public final void setCurrentTopBar(MobileRentAccessoryMainPage.Companion.TopBar topBar) {
        Intrinsics.checkNotNullParameter(topBar, "topBar");
        this.currentTopBar = topBar;
    }

    /* compiled from: MobileRentAccessoryMainAdapter.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0010H\u0002J\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u00142\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\r\u0012\t\u0012\u00070\u0011¢\u0006\u0002\b\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter$MainViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryItemBinding;", "<init>", "(Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter;Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryItemBinding;)V", "getBinding", "()Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryItemBinding;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "scope", "Lkotlinx/coroutines/CoroutineScope;", "rentTimerJob", "Lkotlinx/coroutines/Job;", "items", "", "Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryElementItemBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryModel;", "recycle", "initTopBar", "startRentTimer", "time", "", "initItems", "itemList", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryModelItem;", "initCategory", "categoryId", "", "(I)Lkotlin/Unit;", "initDesc", "initButtons", "setupListeners", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class MainViewHolder extends RecyclerView.ViewHolder {
        private final MobileRentAccessoryItemBinding binding;
        private final Context context;
        private final List<MobileRentAccessoryElementItemBinding> items;
        private Job rentTimerJob;
        private final CoroutineScope scope;
        final /* synthetic */ MobileRentAccessoryMainAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MainViewHolder(MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter, MobileRentAccessoryItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = mobileRentAccessoryMainAdapter;
            this.binding = binding;
            this.context = binding.getRoot().getContext();
            this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
            this.items = CollectionsKt.listOf((Object[]) new MobileRentAccessoryElementItemBinding[]{binding.firstItem, binding.secondItem, binding.thirdItem, binding.fourthItem, binding.fifthItem, binding.sixthItem});
        }

        public final MobileRentAccessoryItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(MobileRentAccessoryModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            initTopBar(model);
            initItems(model.getItems());
            initCategory(model.getCategory());
            initDesc(model);
            initButtons(model);
            setupListeners(model);
        }

        public final void recycle() {
            Job job = this.rentTimerJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.rentTimerJob = null;
            for (MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding : this.items) {
                ImageView ivEffectBackgroundTop = mobileRentAccessoryElementItemBinding.ivEffectBackgroundTop;
                Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
                ImageView ivEffectBackground = mobileRentAccessoryElementItemBinding.ivEffectBackground;
                Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
                ImageView ivEffectForeground = mobileRentAccessoryElementItemBinding.ivEffectForeground;
                Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
                UtilKt.clearEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0170  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0173  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void initTopBar(MobileRentAccessoryModel mobileRentAccessoryModel) {
            boolean z;
            MobileRentAccessoryItemBinding mobileRentAccessoryItemBinding = this.binding;
            MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter = this.this$0;
            mobileRentAccessoryItemBinding.tvNumber.setText("#" + mobileRentAccessoryModel.getListID());
            Companion.UserPosition userPosition = mobileRentAccessoryMainAdapter.parent.getUserPosition();
            if (userPosition != null) {
                CustomCardView locationContainer = mobileRentAccessoryItemBinding.locationContainer;
                Intrinsics.checkNotNullExpressionValue(locationContainer, "locationContainer");
                locationContainer.setVisibility((mobileRentAccessoryModel.getEnterX() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (mobileRentAccessoryModel.getEnterX() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) > 0 || (mobileRentAccessoryModel.getEnterY() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (mobileRentAccessoryModel.getEnterY() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) > 0 || (mobileRentAccessoryModel.getEnterZ() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (mobileRentAccessoryModel.getEnterZ() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) > 0 || mobileRentAccessoryMainAdapter.parent.getUserPosition() != null ? 0 : 8);
                Regex regex = new Regex("\\s+");
                ArrayList arrayList = new ArrayList();
                for (Object obj : regex.split(StringsKt.trim((CharSequence) mobileRentAccessoryModel.getPosName()).toString(), 0)) {
                    if (!StringsKt.isBlank((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                String str = "";
                if (arrayList2.size() >= 2) {
                    str = CollectionsKt.joinToString$default(CollectionsKt.take(arrayList2, 2), "", null, null, 0, null, new Function1() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter$MainViewHolder$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            CharSequence initTopBar$lambda$0$0$1$0;
                            initTopBar$lambda$0$0$1$0 = MobileRentAccessoryMainAdapter.MainViewHolder.initTopBar$lambda$0$0$1$0((String) obj2);
                            return initTopBar$lambda$0$0$1$0;
                        }
                    }, 30, null);
                } else {
                    String str2 = (String) CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
                    if (str2 != null) {
                        str = str2;
                    }
                }
                String format = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(mobileRentAccessoryModel.calculateDistanceToEnter(userPosition) / 1000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                mobileRentAccessoryItemBinding.tvLocation.setText(this.context.getString(R.string.i_km, str, format));
            }
            CustomCardView bizPercentContainer = mobileRentAccessoryItemBinding.bizPercentContainer;
            Intrinsics.checkNotNullExpressionValue(bizPercentContainer, "bizPercentContainer");
            CustomCardView customCardView = bizPercentContainer;
            if (mobileRentAccessoryModel.getBizPercent() > 0) {
                Context context = this.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                if (mobileRentAccessoryModel.getIsMy(context)) {
                    z = true;
                    customCardView.setVisibility(!z ? 0 : 8);
                    mobileRentAccessoryItemBinding.tvBizPercent.setText(this.context.getString(ru.mrlargha.commonui.R.string.i_percent, String.valueOf(mobileRentAccessoryModel.getBizPercent())));
                    mobileRentAccessoryItemBinding.bizPercentContainer.setBackground(mobileRentAccessoryModel.getBizPercentColorBg());
                    CustomCardView timeContainer = mobileRentAccessoryItemBinding.timeContainer;
                    Intrinsics.checkNotNullExpressionValue(timeContainer, "timeContainer");
                    timeContainer.setVisibility(mobileRentAccessoryModel.getRentEndUnix() > 0 ? 0 : 8);
                    startRentTimer(mobileRentAccessoryModel.getRentEndUnix());
                }
            }
            z = false;
            customCardView.setVisibility(!z ? 0 : 8);
            mobileRentAccessoryItemBinding.tvBizPercent.setText(this.context.getString(ru.mrlargha.commonui.R.string.i_percent, String.valueOf(mobileRentAccessoryModel.getBizPercent())));
            mobileRentAccessoryItemBinding.bizPercentContainer.setBackground(mobileRentAccessoryModel.getBizPercentColorBg());
            CustomCardView timeContainer2 = mobileRentAccessoryItemBinding.timeContainer;
            Intrinsics.checkNotNullExpressionValue(timeContainer2, "timeContainer");
            timeContainer2.setVisibility(mobileRentAccessoryModel.getRentEndUnix() > 0 ? 0 : 8);
            startRentTimer(mobileRentAccessoryModel.getRentEndUnix());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence initTopBar$lambda$0$0$1$0(String word) {
            Intrinsics.checkNotNullParameter(word, "word");
            String valueOf = String.valueOf(StringsKt.first(word));
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }

        private final void startRentTimer(long j) {
            Job launch$default;
            MobileRentAccessoryItemBinding mobileRentAccessoryItemBinding = this.binding;
            long currentTimeMillis = (j * 1000) - System.currentTimeMillis();
            Job job = this.rentTimerJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MobileRentAccessoryMainAdapter$MainViewHolder$startRentTimer$1$1(currentTimeMillis, mobileRentAccessoryItemBinding, this, null), 3, null);
            this.rentTimerJob = launch$default;
        }

        private final void initItems(List<MobileRentAccessoryModelItem> list) {
            int i;
            int i2 = 0;
            int i3 = 0;
            for (Object obj : this.items) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding = (MobileRentAccessoryElementItemBinding) obj;
                MobileRentAccessoryModelItem mobileRentAccessoryModelItem = (MobileRentAccessoryModelItem) CollectionsKt.getOrNull(list, i3);
                if (mobileRentAccessoryModelItem != null) {
                    BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MobileRentAccessoryMainAdapter$MainViewHolder$initItems$1$1$1$1(mobileRentAccessoryElementItemBinding, mobileRentAccessoryModelItem, null), 3, null);
                    ImageView ivItem = mobileRentAccessoryElementItemBinding.ivItem;
                    Intrinsics.checkNotNullExpressionValue(ivItem, "ivItem");
                    ivItem.setVisibility(i2);
                    ImageView ivIcon = mobileRentAccessoryElementItemBinding.ivIcon;
                    Intrinsics.checkNotNullExpressionValue(ivIcon, "ivIcon");
                    ivIcon.setVisibility(8);
                    TextView tvCount = mobileRentAccessoryElementItemBinding.tvCount;
                    Intrinsics.checkNotNullExpressionValue(tvCount, "tvCount");
                    tvCount.setVisibility((mobileRentAccessoryModelItem.getEnchanted() > 0 ? 1 : i2) != 0 ? i2 : 8);
                    mobileRentAccessoryElementItemBinding.tvCount.setText("+" + mobileRentAccessoryModelItem.getEnchanted());
                    mobileRentAccessoryElementItemBinding.container.setBackground(mobileRentAccessoryModelItem.getColorId());
                    ImageView ivEffectBackgroundTop = mobileRentAccessoryElementItemBinding.ivEffectBackgroundTop;
                    Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop, "ivEffectBackgroundTop");
                    ImageView ivEffectBackground = mobileRentAccessoryElementItemBinding.ivEffectBackground;
                    Intrinsics.checkNotNullExpressionValue(ivEffectBackground, "ivEffectBackground");
                    ImageView ivEffectForeground = mobileRentAccessoryElementItemBinding.ivEffectForeground;
                    Intrinsics.checkNotNullExpressionValue(ivEffectForeground, "ivEffectForeground");
                    if (UtilKt.setEffect(ivEffectBackgroundTop, ivEffectBackground, ivEffectForeground, Integer.valueOf(mobileRentAccessoryModelItem.getItemID())) != null) {
                        i = 0;
                        i2 = i;
                        i3 = i4;
                    }
                }
                TextView tvCount2 = mobileRentAccessoryElementItemBinding.tvCount;
                Intrinsics.checkNotNullExpressionValue(tvCount2, "tvCount");
                tvCount2.setVisibility(8);
                ImageView ivItem2 = mobileRentAccessoryElementItemBinding.ivItem;
                Intrinsics.checkNotNullExpressionValue(ivItem2, "ivItem");
                ivItem2.setVisibility(8);
                ImageView ivIcon2 = mobileRentAccessoryElementItemBinding.ivIcon;
                Intrinsics.checkNotNullExpressionValue(ivIcon2, "ivIcon");
                i = 0;
                ivIcon2.setVisibility(0);
                CustomCardView container = mobileRentAccessoryElementItemBinding.container;
                Intrinsics.checkNotNullExpressionValue(container, "container");
                CustomCardView.setBackground$default(container, Color.parseColor("#33FFFFFF"), Color.parseColor("#0DFFFFFF"), null, null, 12, null);
                ImageView ivEffectBackgroundTop2 = mobileRentAccessoryElementItemBinding.ivEffectBackgroundTop;
                Intrinsics.checkNotNullExpressionValue(ivEffectBackgroundTop2, "ivEffectBackgroundTop");
                ImageView ivEffectBackground2 = mobileRentAccessoryElementItemBinding.ivEffectBackground;
                Intrinsics.checkNotNullExpressionValue(ivEffectBackground2, "ivEffectBackground");
                ImageView ivEffectForeground2 = mobileRentAccessoryElementItemBinding.ivEffectForeground;
                Intrinsics.checkNotNullExpressionValue(ivEffectForeground2, "ivEffectForeground");
                UtilKt.setEffect(ivEffectBackgroundTop2, ivEffectBackground2, ivEffectForeground2, (Integer) (-1));
                Unit unit = Unit.INSTANCE;
                i2 = i;
                i3 = i4;
            }
        }

        private final Unit initCategory(int i) {
            MobileRentAccessoryItemBinding mobileRentAccessoryItemBinding = this.binding;
            MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel = (MobileRentAccessoryCategoryModel) this.this$0.getCategory.invoke(Integer.valueOf(i));
            Object obj = null;
            if (mobileRentAccessoryCategoryModel != null) {
                mobileRentAccessoryItemBinding.tvCategory.setText(mobileRentAccessoryCategoryModel.getName());
                Iterator<E> it = MobileRentAccessoryCategoryIcon.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((MobileRentAccessoryCategoryIcon) next).getId() == mobileRentAccessoryCategoryModel.getId()) {
                        obj = next;
                        break;
                    }
                }
                MobileRentAccessoryCategoryIcon mobileRentAccessoryCategoryIcon = (MobileRentAccessoryCategoryIcon) obj;
                if (mobileRentAccessoryCategoryIcon != null) {
                    mobileRentAccessoryItemBinding.ivCategory.setImageResource(mobileRentAccessoryCategoryIcon.getResId());
                }
                mobileRentAccessoryItemBinding.tvCategory.setTextColor(Color.parseColor(mobileRentAccessoryCategoryModel.getColor()));
                mobileRentAccessoryItemBinding.ivCategory.setImageTintList(ColorStateList.valueOf(Color.parseColor(mobileRentAccessoryCategoryModel.getColor())));
                CustomCardView categoryContainer = mobileRentAccessoryItemBinding.categoryContainer;
                Intrinsics.checkNotNullExpressionValue(categoryContainer, "categoryContainer");
                CustomCardView.setBackground$default(categoryContainer, ColorUtils.setAlphaComponent(Color.parseColor(mobileRentAccessoryCategoryModel.getColorBG()), 50), 0, null, null, 12, null);
                return Unit.INSTANCE;
            }
            return null;
        }

        private final void initDesc(MobileRentAccessoryModel mobileRentAccessoryModel) {
            MobileRentAccessoryItemBinding mobileRentAccessoryItemBinding = this.binding;
            mobileRentAccessoryItemBinding.tvCost.setText(MoneyFormatter.INSTANCE.formatPlain(mobileRentAccessoryModel.getCost()));
            mobileRentAccessoryItemBinding.tvDesc.setText(mobileRentAccessoryModel.getDescription());
            TextView textView = mobileRentAccessoryItemBinding.tvNickName;
            String nickName = mobileRentAccessoryModel.getNickName();
            textView.setText(nickName + "[" + mobileRentAccessoryModel.getOwnerPlayerUID() + "]");
        }

        private final void initButtons(MobileRentAccessoryModel mobileRentAccessoryModel) {
            MobileRentAccessoryItemBinding mobileRentAccessoryItemBinding = this.binding;
            MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter = this.this$0;
            Context context = this.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            boolean isMy = mobileRentAccessoryModel.getIsMy(context);
            Context context2 = this.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            boolean isRent = mobileRentAccessoryModel.getIsRent(context2);
            if (isMy && mobileRentAccessoryModel.getStatus() == 0) {
                CustomCardView btnRent = mobileRentAccessoryItemBinding.btnRent;
                Intrinsics.checkNotNullExpressionValue(btnRent, "btnRent");
                btnRent.setVisibility(8);
                CustomCardView btnDeleteTwo = mobileRentAccessoryItemBinding.btnDeleteTwo;
                Intrinsics.checkNotNullExpressionValue(btnDeleteTwo, "btnDeleteTwo");
                btnDeleteTwo.setVisibility(8);
                LinearLayout passContainer = mobileRentAccessoryItemBinding.passContainer;
                Intrinsics.checkNotNullExpressionValue(passContainer, "passContainer");
                passContainer.setVisibility(0);
                CustomCardView btnPass = mobileRentAccessoryItemBinding.btnPass;
                Intrinsics.checkNotNullExpressionValue(btnPass, "btnPass");
                CustomCardView.setBackground$default(btnPass, Color.parseColor("#FF8183"), Color.parseColor("#DF0004"), null, null, 12, null);
                mobileRentAccessoryItemBinding.tvPass.setText(this.context.getString(R.string.mobile_give_lot_for_rent));
            } else if ((mobileRentAccessoryModel.getStatus() == 2 && isMy) || (mobileRentAccessoryModel.getStatus() == 3 && isRent)) {
                CustomCardView btnRent2 = mobileRentAccessoryItemBinding.btnRent;
                Intrinsics.checkNotNullExpressionValue(btnRent2, "btnRent");
                btnRent2.setVisibility(0);
                LinearLayout passContainer2 = mobileRentAccessoryItemBinding.passContainer;
                Intrinsics.checkNotNullExpressionValue(passContainer2, "passContainer");
                passContainer2.setVisibility(8);
                CustomCardView btnDeleteTwo2 = mobileRentAccessoryItemBinding.btnDeleteTwo;
                Intrinsics.checkNotNullExpressionValue(btnDeleteTwo2, "btnDeleteTwo");
                btnDeleteTwo2.setVisibility(8);
                CustomCardView btnRent3 = mobileRentAccessoryItemBinding.btnRent;
                Intrinsics.checkNotNullExpressionValue(btnRent3, "btnRent");
                CustomCardView.setBackground$default(btnRent3, Color.parseColor("#FFBE4D"), Color.parseColor("#F39E09"), null, null, 12, null);
                mobileRentAccessoryItemBinding.tvRent.setText(this.context.getString(R.string.mobile_take_items));
            } else if (mobileRentAccessoryModel.getStatus() == 1 && isMy && mobileRentAccessoryMainAdapter.currentTopBar == MobileRentAccessoryMainPage.Companion.TopBar.MY) {
                CustomCardView btnRent4 = mobileRentAccessoryItemBinding.btnRent;
                Intrinsics.checkNotNullExpressionValue(btnRent4, "btnRent");
                btnRent4.setVisibility(8);
                LinearLayout passContainer3 = mobileRentAccessoryItemBinding.passContainer;
                Intrinsics.checkNotNullExpressionValue(passContainer3, "passContainer");
                passContainer3.setVisibility(0);
                CustomCardView btnDeleteTwo3 = mobileRentAccessoryItemBinding.btnDeleteTwo;
                Intrinsics.checkNotNullExpressionValue(btnDeleteTwo3, "btnDeleteTwo");
                btnDeleteTwo3.setVisibility(8);
                CustomCardView btnPass2 = mobileRentAccessoryItemBinding.btnPass;
                Intrinsics.checkNotNullExpressionValue(btnPass2, "btnPass");
                CustomCardView.setBackground$default(btnPass2, Color.parseColor("#4BBF2E"), Color.parseColor("#7ADA62"), null, null, 12, null);
                mobileRentAccessoryItemBinding.tvPass.setText(this.context.getString(R.string.mobile_raise_rating));
            } else if (mobileRentAccessoryModel.getStatus() == 1 && isMy && mobileRentAccessoryMainAdapter.currentTopBar == MobileRentAccessoryMainPage.Companion.TopBar.ALL) {
                CustomCardView btnRent5 = mobileRentAccessoryItemBinding.btnRent;
                Intrinsics.checkNotNullExpressionValue(btnRent5, "btnRent");
                btnRent5.setVisibility(8);
                LinearLayout passContainer4 = mobileRentAccessoryItemBinding.passContainer;
                Intrinsics.checkNotNullExpressionValue(passContainer4, "passContainer");
                passContainer4.setVisibility(8);
                CustomCardView btnDeleteTwo4 = mobileRentAccessoryItemBinding.btnDeleteTwo;
                Intrinsics.checkNotNullExpressionValue(btnDeleteTwo4, "btnDeleteTwo");
                btnDeleteTwo4.setVisibility(0);
            } else if (mobileRentAccessoryModel.getStatus() != 1 || isMy) {
            } else {
                CustomCardView btnDeleteTwo5 = mobileRentAccessoryItemBinding.btnDeleteTwo;
                Intrinsics.checkNotNullExpressionValue(btnDeleteTwo5, "btnDeleteTwo");
                btnDeleteTwo5.setVisibility(8);
                CustomCardView btnRent6 = mobileRentAccessoryItemBinding.btnRent;
                Intrinsics.checkNotNullExpressionValue(btnRent6, "btnRent");
                btnRent6.setVisibility(0);
                LinearLayout passContainer5 = mobileRentAccessoryItemBinding.passContainer;
                Intrinsics.checkNotNullExpressionValue(passContainer5, "passContainer");
                passContainer5.setVisibility(8);
                CustomCardView btnRent7 = mobileRentAccessoryItemBinding.btnRent;
                Intrinsics.checkNotNullExpressionValue(btnRent7, "btnRent");
                CustomCardView.setBackground$default(btnRent7, Color.parseColor("#DB81FF"), Color.parseColor("#8A4CF4"), null, null, 12, null);
                mobileRentAccessoryItemBinding.tvRent.setText(this.context.getString(R.string.mobile_rent));
            }
        }

        private final void setupListeners(final MobileRentAccessoryModel mobileRentAccessoryModel) {
            MobileRentAccessoryItemBinding mobileRentAccessoryItemBinding = this.binding;
            final MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter = this.this$0;
            mobileRentAccessoryItemBinding.btnDeleteThree.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter$MainViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRentAccessoryMainAdapter.MainViewHolder.setupListeners$lambda$0$0(MobileRentAccessoryModel.this, mobileRentAccessoryMainAdapter, view);
                }
            });
            mobileRentAccessoryItemBinding.btnRent.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter$MainViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRentAccessoryMainAdapter.MainViewHolder.setupListeners$lambda$0$1(MobileRentAccessoryModel.this, this, mobileRentAccessoryMainAdapter, view);
                }
            });
            mobileRentAccessoryItemBinding.btnPass.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter$MainViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRentAccessoryMainAdapter.MainViewHolder.setupListeners$lambda$0$2(MobileRentAccessoryModel.this, this, mobileRentAccessoryMainAdapter, view);
                }
            });
            mobileRentAccessoryItemBinding.btnDeleteTwo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter$MainViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRentAccessoryMainAdapter.MainViewHolder.setupListeners$lambda$0$3(MobileRentAccessoryModel.this, mobileRentAccessoryMainAdapter, view);
                }
            });
            int i = 0;
            for (Object obj : this.items) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                MobileRentAccessoryElementItemBinding mobileRentAccessoryElementItemBinding = (MobileRentAccessoryElementItemBinding) obj;
                MobileRentAccessoryModelItem mobileRentAccessoryModelItem = (MobileRentAccessoryModelItem) CollectionsKt.getOrNull(mobileRentAccessoryModel.getItems(), i);
                if (mobileRentAccessoryModelItem != null) {
                    final MobileRentAccessorySendItemModel mobileRentAccessorySendItemModel = new MobileRentAccessorySendItemModel(mobileRentAccessoryModel.getListUID(), mobileRentAccessoryModel.getListID(), mobileRentAccessoryModel.getBizID(), mobileRentAccessoryModelItem.getSlotId());
                    mobileRentAccessoryElementItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter$MainViewHolder$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MobileRentAccessoryMainAdapter.MainViewHolder.setupListeners$lambda$0$4$0$0(MobileRentAccessoryMainAdapter.this, mobileRentAccessorySendItemModel, view);
                        }
                    });
                }
                i = i2;
            }
            mobileRentAccessoryItemBinding.locationContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter$MainViewHolder$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRentAccessoryMainAdapter.MainViewHolder.setupListeners$lambda$0$5(MobileRentAccessoryModel.this, mobileRentAccessoryMainAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0$0(MobileRentAccessoryModel mobileRentAccessoryModel, MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter, View view) {
            MobileRentAccessorySendModel mobileRentAccessorySendModel = new MobileRentAccessorySendModel(mobileRentAccessoryModel.getListUID(), mobileRentAccessoryModel.getListID(), mobileRentAccessoryModel.getBizID());
            Log.d("TAG", "setupListeners: ");
            mobileRentAccessoryMainAdapter.sendEvent.invoke(MobilePHoneSendSubIds.RENT_ACCESSORY_DELETE, StringKt.toStringJson(mobileRentAccessorySendModel), 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
            r6.sendEvent.invoke(ru.mrlargha.feature.mobile.presentation.MobilePHoneSendSubIds.RENT_ACCESSORY_TAKE_ITEMS, ru.mrlargha.commonui.utils.StringKt.toStringJson(r7), 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0028, code lost:
            if (r4.getIsMy(r0) == false) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x003a, code lost:
            if (r4.getIsRent(r5) != false) goto L5;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void setupListeners$lambda$0$1(MobileRentAccessoryModel mobileRentAccessoryModel, MainViewHolder mainViewHolder, MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter, View view) {
            MobileRentAccessorySendModel mobileRentAccessorySendModel = new MobileRentAccessorySendModel(mobileRentAccessoryModel.getListUID(), mobileRentAccessoryModel.getListID(), mobileRentAccessoryModel.getBizID());
            if (mobileRentAccessoryModel.getStatus() == 2) {
                Context context = mainViewHolder.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
            }
            if (mobileRentAccessoryModel.getStatus() == 3) {
                Context context2 = mainViewHolder.context;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
            }
            mobileRentAccessoryMainAdapter.sendEvent.invoke(MobilePHoneSendSubIds.RENT_ACCESSORY_RENT, StringKt.toStringJson(mobileRentAccessorySendModel), 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0$2(MobileRentAccessoryModel mobileRentAccessoryModel, MainViewHolder mainViewHolder, MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter, View view) {
            MobileRentAccessorySendModel mobileRentAccessorySendModel = new MobileRentAccessorySendModel(mobileRentAccessoryModel.getListUID(), mobileRentAccessoryModel.getListID(), mobileRentAccessoryModel.getBizID());
            if (mobileRentAccessoryModel.getStatus() == 1) {
                Context context = mainViewHolder.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                if (mobileRentAccessoryModel.getIsMy(context) && mobileRentAccessoryMainAdapter.currentTopBar == MobileRentAccessoryMainPage.Companion.TopBar.MY) {
                    mobileRentAccessoryMainAdapter.sendEvent.invoke(MobilePHoneSendSubIds.RENT_ACCESSORY_RAISE, StringKt.toStringJson(mobileRentAccessorySendModel), 0);
                    return;
                }
            }
            mobileRentAccessoryMainAdapter.sendEvent.invoke(MobilePHoneSendSubIds.RENT_ACCESSORY_PUBLIC, StringKt.toStringJson(mobileRentAccessorySendModel), 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0$3(MobileRentAccessoryModel mobileRentAccessoryModel, MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter, View view) {
            mobileRentAccessoryMainAdapter.sendEvent.invoke(MobilePHoneSendSubIds.RENT_ACCESSORY_DELETE, StringKt.toStringJson(new MobileRentAccessorySendModel(mobileRentAccessoryModel.getListUID(), mobileRentAccessoryModel.getListID(), mobileRentAccessoryModel.getBizID())), 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0$4$0$0(MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter, MobileRentAccessorySendItemModel mobileRentAccessorySendItemModel, View view) {
            mobileRentAccessoryMainAdapter.sendEvent.invoke(MobilePHoneSendSubIds.RENT_ACCESSORY_INFO, StringKt.toStringJson(mobileRentAccessorySendItemModel), 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0$5(MobileRentAccessoryModel mobileRentAccessoryModel, MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter, View view) {
            mobileRentAccessoryMainAdapter.sendEvent.invoke(MobilePHoneSendSubIds.RENT_ACCESSORY_CLICK_LOCATION, StringKt.toStringJson(new MobileRentAccessorySendModel(mobileRentAccessoryModel.getListUID(), mobileRentAccessoryModel.getListID(), mobileRentAccessoryModel.getBizID())), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        MobileRentAccessoryItemBinding inflate = MobileRentAccessoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MainViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MainViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MobileRentAccessoryModel mobileRentAccessoryModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(mobileRentAccessoryModel, "get(...)");
        holder.onBind(mobileRentAccessoryModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(MainViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.recycle();
        super.onViewRecycled((MobileRentAccessoryMainAdapter) holder);
    }

    /* compiled from: MobileRentAccessoryMainAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter$Companion$diffUtilCallback$1;", "UserPosition", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* compiled from: MobileRentAccessoryMainAdapter.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter$Companion$UserPosition;", "", "x", "", "y", "z", "<init>", "(DDD)V", "getX", "()D", "getY", "getZ", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class UserPosition {
            private final double x;
            private final double y;
            private final double z;

            public static /* synthetic */ UserPosition copy$default(UserPosition userPosition, double d, double d2, double d3, int i, Object obj) {
                if ((i & 1) != 0) {
                    d = userPosition.x;
                }
                double d4 = d;
                if ((i & 2) != 0) {
                    d2 = userPosition.y;
                }
                double d5 = d2;
                if ((i & 4) != 0) {
                    d3 = userPosition.z;
                }
                return userPosition.copy(d4, d5, d3);
            }

            public final double component1() {
                return this.x;
            }

            public final double component2() {
                return this.y;
            }

            public final double component3() {
                return this.z;
            }

            public final UserPosition copy(double d, double d2, double d3) {
                return new UserPosition(d, d2, d3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof UserPosition) {
                    UserPosition userPosition = (UserPosition) obj;
                    return Double.compare(this.x, userPosition.x) == 0 && Double.compare(this.y, userPosition.y) == 0 && Double.compare(this.z, userPosition.z) == 0;
                }
                return false;
            }

            public int hashCode() {
                return (((Double.hashCode(this.x) * 31) + Double.hashCode(this.y)) * 31) + Double.hashCode(this.z);
            }

            public String toString() {
                double d = this.x;
                double d2 = this.y;
                return "UserPosition(x=" + d + ", y=" + d2 + ", z=" + this.z + ")";
            }

            public UserPosition(double d, double d2, double d3) {
                this.x = d;
                this.y = d2;
                this.z = d3;
            }

            public final double getX() {
                return this.x;
            }

            public final double getY() {
                return this.y;
            }

            public final double getZ() {
                return this.z;
            }
        }
    }
}
