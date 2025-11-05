package ru.mrlargha.feature.arizona.cases.pages.adapters;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.arizona.cases.CasesGuaranteedPrizeModel;
import ru.mrlargha.feature.arizona.cases.CasesResponseKt;
import ru.mrlargha.feature.arizona.cases.CasesUsedModel;
import ru.mrlargha.feature.arizona.cases.CasesUsedType;
import ru.mrlargha.feature.arizona.cases.databinding.ArizonaCasesOpenItemBinding;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesOpenAdapter;
/* compiled from: CasesOpenAdapter.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002./BM\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\nJ\u0018\u0010$\u001a\u00020\n2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010&H\u0016J\u001c\u0010'\u001a\u00060\u0003R\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0006H\u0016J\u001c\u0010+\u001a\u00020\n2\n\u0010,\u001a\u00060\u0003R\u00020\u00002\u0006\u0010-\u001a\u00020\u0006H\u0016R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR,\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesOpenAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesOpenAdapter$OpenViewHolder;", "onClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cost", "", "updateCost", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "getUpdateCost", "value", "", "isOpen", "()Z", "", "selectList", "getSelectList", "()Ljava/util/List;", "", "openList", "getOpenList", "()Ljava/util/Set;", "usedPrize", "Lru/mrlargha/feature/arizona/cases/CasesUsedModel;", "clearSelectList", "usedType", "Lru/mrlargha/feature/arizona/cases/CasesUsedType;", "switchIsOpen", "setOpenedList", "submitList", "list", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "OpenViewHolder", "DiffUtilCallback", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesOpenAdapter extends ListAdapter<CasesGuaranteedPrizeModel, OpenViewHolder> {
    private boolean isOpen;
    private final Function1<Integer, Unit> onClick;
    private Set<Integer> openList;
    private List<Integer> selectList;
    private final Function1<Integer, Unit> updateCost;
    private List<CasesUsedModel> usedPrize;

    public final Function1<Integer, Unit> getOnClick() {
        return this.onClick;
    }

    public final Function1<Integer, Unit> getUpdateCost() {
        return this.updateCost;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CasesOpenAdapter(Function1<? super Integer, Unit> onClick, Function1<? super Integer, Unit> updateCost) {
        super(new DiffUtilCallback());
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(updateCost, "updateCost");
        this.onClick = onClick;
        this.updateCost = updateCost;
        this.selectList = new ArrayList();
        this.openList = new LinkedHashSet();
        this.usedPrize = new ArrayList();
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final List<Integer> getSelectList() {
        return this.selectList;
    }

    public final Set<Integer> getOpenList() {
        return this.openList;
    }

    public final void clearSelectList(CasesUsedType usedType) {
        Intrinsics.checkNotNullParameter(usedType, "usedType");
        for (Number number : this.selectList) {
            this.usedPrize.add(new CasesUsedModel(number.intValue(), usedType));
        }
        this.selectList.clear();
        notifyDataSetChanged();
    }

    public final void switchIsOpen() {
        this.isOpen = !this.isOpen;
        notifyDataSetChanged();
    }

    public final void setOpenedList() {
        this.openList.addAll(this.selectList);
        this.selectList.clear();
        if (getCurrentList().size() == this.openList.size()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CasesOpenAdapter$setOpenedList$1(this, null), 3, null);
        }
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List<CasesGuaranteedPrizeModel> list) {
        this.openList.clear();
        this.isOpen = false;
        this.selectList.clear();
        this.usedPrize.clear();
        super.submitList(list);
    }

    /* compiled from: CasesOpenAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesOpenAdapter$OpenViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesOpenItemBinding;", "<init>", "(Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesOpenAdapter;Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesOpenItemBinding;)V", "getBinding", "()Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesOpenItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "position", "", "initialize", "setupListeners", "id", "cost", "isHave", "", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class OpenViewHolder extends RecyclerView.ViewHolder {
        private final ArizonaCasesOpenItemBinding binding;
        final /* synthetic */ CasesOpenAdapter this$0;

        /* compiled from: CasesOpenAdapter.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CasesUsedType.values().length];
                try {
                    iArr[CasesUsedType.GET.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CasesUsedType.SCHISM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initialize$lambda$0$3(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0$1(View view) {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenViewHolder(CasesOpenAdapter casesOpenAdapter, ArizonaCasesOpenItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = casesOpenAdapter;
            this.binding = binding;
        }

        public final ArizonaCasesOpenItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(CasesGuaranteedPrizeModel model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            initialize(model, i);
        }

        private final void initialize(CasesGuaranteedPrizeModel casesGuaranteedPrizeModel, int i) {
            Object obj;
            boolean z;
            Object obj2;
            ArizonaCasesOpenItemBinding arizonaCasesOpenItemBinding = this.binding;
            CasesOpenAdapter casesOpenAdapter = this.this$0;
            TextView tvGotIt = arizonaCasesOpenItemBinding.tvGotIt;
            Intrinsics.checkNotNullExpressionValue(tvGotIt, "tvGotIt");
            tvGotIt.setVisibility(8);
            TextView tvSchism = arizonaCasesOpenItemBinding.tvSchism;
            Intrinsics.checkNotNullExpressionValue(tvSchism, "tvSchism");
            tvSchism.setVisibility(8);
            arizonaCasesOpenItemBinding.ivCheck.setColorFilter(-1);
            if (casesOpenAdapter.getCurrentList().size() < 2 && casesOpenAdapter.isOpen()) {
                casesOpenAdapter.getSelectList().add(Integer.valueOf(i));
                casesOpenAdapter.getUpdateCost().invoke(Integer.valueOf(casesGuaranteedPrizeModel.getShards()));
            }
            arizonaCasesOpenItemBinding.bg.setBackgroundResource(casesGuaranteedPrizeModel.getBgType().getResId());
            Iterator<T> it = UtilsKt.getItemsName().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ItemsInfo) obj).getId() == casesGuaranteedPrizeModel.getItem()) {
                    break;
                }
            }
            ItemsInfo itemsInfo = (ItemsInfo) obj;
            Log.d(CasesResponseKt.CASES_TAG, String.valueOf(casesGuaranteedPrizeModel.getItem()));
            if (itemsInfo != null) {
                if (casesGuaranteedPrizeModel.getCustom_image() != null) {
                    ImageView ivPrize = arizonaCasesOpenItemBinding.ivPrize;
                    Intrinsics.checkNotNullExpressionValue(ivPrize, "ivPrize");
                    CasesResponseKt.getCaseImageUrl(ivPrize, casesGuaranteedPrizeModel.getCustom_image() + ".webp");
                } else {
                    ImageView ivPrize2 = arizonaCasesOpenItemBinding.ivPrize;
                    Intrinsics.checkNotNullExpressionValue(ivPrize2, "ivPrize");
                    CasesResponseKt.getCaseImageUrl(ivPrize2, itemsInfo.getIcon());
                }
                arizonaCasesOpenItemBinding.tvTitle.setText(itemsInfo.getName() + "\n" + casesGuaranteedPrizeModel.m12065getCount());
            }
            arizonaCasesOpenItemBinding.tvCost.setText("+" + casesGuaranteedPrizeModel.getShards());
            TextView tvClose = arizonaCasesOpenItemBinding.tvClose;
            Intrinsics.checkNotNullExpressionValue(tvClose, "tvClose");
            tvClose.setVisibility(casesOpenAdapter.isOpen() ? 4 : 0);
            FrameLayout openContainer = arizonaCasesOpenItemBinding.openContainer;
            Intrinsics.checkNotNullExpressionValue(openContainer, "openContainer");
            openContainer.setVisibility(!casesOpenAdapter.isOpen() ? 4 : 0);
            LinearLayout costContainer = arizonaCasesOpenItemBinding.costContainer;
            Intrinsics.checkNotNullExpressionValue(costContainer, "costContainer");
            costContainer.setVisibility(!casesOpenAdapter.isOpen() ? 4 : 0);
            arizonaCasesOpenItemBinding.ivCheck.setAlpha(casesOpenAdapter.getSelectList().contains(Integer.valueOf(i)) ? 1.0f : 0.36f);
            int shards = casesGuaranteedPrizeModel.getShards();
            List<CasesUsedModel> list = casesOpenAdapter.usedPrize;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (CasesUsedModel casesUsedModel : list) {
                    if (casesUsedModel.getItemId() == i) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            setupListeners(i, shards, z);
            if (!casesOpenAdapter.isOpen()) {
                if (casesOpenAdapter.getOpenList().contains(Integer.valueOf(i))) {
                    arizonaCasesOpenItemBinding.bg.setAlpha(1.0f);
                    TextView tvClose2 = arizonaCasesOpenItemBinding.tvClose;
                    Intrinsics.checkNotNullExpressionValue(tvClose2, "tvClose");
                    tvClose2.setVisibility(4);
                    FrameLayout openContainer2 = arizonaCasesOpenItemBinding.openContainer;
                    Intrinsics.checkNotNullExpressionValue(openContainer2, "openContainer");
                    openContainer2.setVisibility(0);
                    LinearLayout costContainer2 = arizonaCasesOpenItemBinding.costContainer;
                    Intrinsics.checkNotNullExpressionValue(costContainer2, "costContainer");
                    costContainer2.setVisibility(0);
                    arizonaCasesOpenItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.adapters.CasesOpenAdapter$OpenViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CasesOpenAdapter.OpenViewHolder.initialize$lambda$0$3(view);
                        }
                    });
                    return;
                }
                TextView tvClose3 = arizonaCasesOpenItemBinding.tvClose;
                Intrinsics.checkNotNullExpressionValue(tvClose3, "tvClose");
                tvClose3.setVisibility(0);
                FrameLayout openContainer3 = arizonaCasesOpenItemBinding.openContainer;
                Intrinsics.checkNotNullExpressionValue(openContainer3, "openContainer");
                openContainer3.setVisibility(4);
                LinearLayout costContainer3 = arizonaCasesOpenItemBinding.costContainer;
                Intrinsics.checkNotNullExpressionValue(costContainer3, "costContainer");
                costContainer3.setVisibility(4);
                arizonaCasesOpenItemBinding.bg.setAlpha(casesOpenAdapter.getSelectList().contains(Integer.valueOf(i)) ? 1.0f : 0.36f);
                return;
            }
            arizonaCasesOpenItemBinding.ivPrize.setAlpha(0.0f);
            arizonaCasesOpenItemBinding.bg.setAlpha(1.0f);
            List<CasesUsedModel> list2 = casesOpenAdapter.usedPrize;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (CasesUsedModel casesUsedModel2 : list2) {
                    if (casesUsedModel2.getItemId() == i) {
                        arizonaCasesOpenItemBinding.ivCheck.setAlpha(1.0f);
                        arizonaCasesOpenItemBinding.ivCheck.setColorFilter(Color.parseColor("#7FDD2D"));
                        LinearLayout costContainer4 = arizonaCasesOpenItemBinding.costContainer;
                        Intrinsics.checkNotNullExpressionValue(costContainer4, "costContainer");
                        costContainer4.setVisibility(4);
                        List list3 = casesOpenAdapter.usedPrize;
                        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                            Iterator it2 = list3.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if (((CasesUsedModel) it2.next()).getItemId() == i) {
                                    Iterator it3 = casesOpenAdapter.usedPrize.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            obj2 = null;
                                            break;
                                        }
                                        Object next = it3.next();
                                        if (((CasesUsedModel) next).getItemId() == i) {
                                            obj2 = next;
                                            break;
                                        }
                                    }
                                    CasesUsedModel casesUsedModel3 = (CasesUsedModel) obj2;
                                    if (casesUsedModel3 != null) {
                                        int i2 = WhenMappings.$EnumSwitchMapping$0[casesUsedModel3.getUsedType().ordinal()];
                                        if (i2 == 1) {
                                            TextView tvGotIt2 = arizonaCasesOpenItemBinding.tvGotIt;
                                            Intrinsics.checkNotNullExpressionValue(tvGotIt2, "tvGotIt");
                                            tvGotIt2.setVisibility(0);
                                            TextView tvSchism2 = arizonaCasesOpenItemBinding.tvSchism;
                                            Intrinsics.checkNotNullExpressionValue(tvSchism2, "tvSchism");
                                            tvSchism2.setVisibility(8);
                                        } else if (i2 != 2) {
                                            throw new NoWhenBranchMatchedException();
                                        } else {
                                            TextView tvGotIt3 = arizonaCasesOpenItemBinding.tvGotIt;
                                            Intrinsics.checkNotNullExpressionValue(tvGotIt3, "tvGotIt");
                                            tvGotIt3.setVisibility(8);
                                            TextView tvSchism3 = arizonaCasesOpenItemBinding.tvSchism;
                                            Intrinsics.checkNotNullExpressionValue(tvSchism3, "tvSchism");
                                            tvSchism3.setVisibility(0);
                                        }
                                    }
                                }
                            }
                        }
                        arizonaCasesOpenItemBinding.ivPrize.animate().alpha(1.0f).setDuration(600L).setInterpolator(new DecelerateInterpolator()).start();
                    }
                }
            }
            LinearLayout costContainer5 = arizonaCasesOpenItemBinding.costContainer;
            Intrinsics.checkNotNullExpressionValue(costContainer5, "costContainer");
            costContainer5.setVisibility(0);
            arizonaCasesOpenItemBinding.ivPrize.animate().alpha(1.0f).setDuration(600L).setInterpolator(new DecelerateInterpolator()).start();
        }

        private final void setupListeners(final int i, final int i2, boolean z) {
            ArizonaCasesOpenItemBinding arizonaCasesOpenItemBinding = this.binding;
            final CasesOpenAdapter casesOpenAdapter = this.this$0;
            if (casesOpenAdapter.isOpen()) {
                if (!z && casesOpenAdapter.getCurrentList().size() > 1) {
                    arizonaCasesOpenItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.adapters.CasesOpenAdapter$OpenViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CasesOpenAdapter.OpenViewHolder.setupListeners$lambda$0$0(CasesOpenAdapter.this, i, i2, this, view);
                        }
                    });
                    return;
                } else {
                    arizonaCasesOpenItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.adapters.CasesOpenAdapter$OpenViewHolder$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CasesOpenAdapter.OpenViewHolder.setupListeners$lambda$0$1(view);
                        }
                    });
                    return;
                }
            }
            arizonaCasesOpenItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.adapters.CasesOpenAdapter$OpenViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CasesOpenAdapter.OpenViewHolder.setupListeners$lambda$0$2(CasesOpenAdapter.this, i, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0$0(CasesOpenAdapter casesOpenAdapter, int i, int i2, OpenViewHolder openViewHolder, View view) {
            if (casesOpenAdapter.getSelectList().contains(Integer.valueOf(i))) {
                casesOpenAdapter.getSelectList().remove(Integer.valueOf(i));
                casesOpenAdapter.getOnClick().invoke(Integer.valueOf(-i2));
            } else {
                casesOpenAdapter.getSelectList().add(Integer.valueOf(i));
                casesOpenAdapter.getOnClick().invoke(Integer.valueOf(i2));
            }
            casesOpenAdapter.notifyItemChanged(openViewHolder.getBindingAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0$2(CasesOpenAdapter casesOpenAdapter, int i, OpenViewHolder openViewHolder, View view) {
            casesOpenAdapter.getSelectList().add(Integer.valueOf(i));
            casesOpenAdapter.setOpenedList();
            casesOpenAdapter.notifyItemChanged(openViewHolder.getBindingAdapterPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OpenViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ArizonaCasesOpenItemBinding inflate = ArizonaCasesOpenItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new OpenViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OpenViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CasesGuaranteedPrizeModel casesGuaranteedPrizeModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(casesGuaranteedPrizeModel, "get(...)");
        holder.onBind(casesGuaranteedPrizeModel, i);
    }

    /* compiled from: CasesOpenAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesOpenAdapter$DiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class DiffUtilCallback extends DiffUtil.ItemCallback<CasesGuaranteedPrizeModel> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CasesGuaranteedPrizeModel oldItem, CasesGuaranteedPrizeModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getItem() == newItem.getItem();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CasesGuaranteedPrizeModel oldItem, CasesGuaranteedPrizeModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
