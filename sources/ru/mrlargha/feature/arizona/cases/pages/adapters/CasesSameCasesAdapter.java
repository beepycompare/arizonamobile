package ru.mrlargha.feature.arizona.cases.pages.adapters;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.feature.arizona.cases.CasesCurrencyType;
import ru.mrlargha.feature.arizona.cases.CasesSameCasesModel;
import ru.mrlargha.feature.arizona.cases.data.remote.models.CasesBadgesModel;
import ru.mrlargha.feature.arizona.cases.databinding.ArizonaCasesSameCasesItemBinding;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesSameCasesAdapter;
/* compiled from: CasesSameCasesAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0016\u0017\u0018B*\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u001c\u0010\u0013\u001a\u00020\n2\n\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesSameCasesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/arizona/cases/CasesSameCasesModel;", "Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesSameCasesAdapter$SameCasesViewHolder;", "onClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "caseId", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "SameCasesViewHolder", "Companion", "DiffUtilCallback", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesSameCasesAdapter extends ListAdapter<CasesSameCasesModel, SameCasesViewHolder> {
    public static final String BENEFIT = "yellow";
    public static final Companion Companion = new Companion(null);
    public static final String NEW = "red";
    public static final String TOP = "green";
    private final Function1<Integer, Unit> onClick;

    public final Function1<Integer, Unit> getOnClick() {
        return this.onClick;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CasesSameCasesAdapter(Function1<? super Integer, Unit> onClick) {
        super(new DiffUtilCallback());
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
    }

    /* compiled from: CasesSameCasesAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesSameCasesAdapter$SameCasesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesSameCasesItemBinding;", "<init>", "(Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesSameCasesAdapter;Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesSameCasesItemBinding;)V", "getBinding", "()Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesSameCasesItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/feature/arizona/cases/CasesSameCasesModel;", "initialize", "setupListeners", "caseId", "", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class SameCasesViewHolder extends RecyclerView.ViewHolder {
        private final ArizonaCasesSameCasesItemBinding binding;
        final /* synthetic */ CasesSameCasesAdapter this$0;

        /* compiled from: CasesSameCasesAdapter.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CasesCurrencyType.values().length];
                try {
                    iArr[CasesCurrencyType.RUB.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CasesCurrencyType.AZ.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SameCasesViewHolder(CasesSameCasesAdapter casesSameCasesAdapter, ArizonaCasesSameCasesItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = casesSameCasesAdapter;
            this.binding = binding;
        }

        public final ArizonaCasesSameCasesItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(CasesSameCasesModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            initialize(model);
            setupListeners(model.getId());
        }

        private final void initialize(CasesSameCasesModel casesSameCasesModel) {
            ArizonaCasesSameCasesItemBinding arizonaCasesSameCasesItemBinding = this.binding;
            Log.d("CasesScreen", "initialize: " + casesSameCasesModel);
            arizonaCasesSameCasesItemBinding.tvPrizeName.setText(casesSameCasesModel.getTitle());
            Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/cases/" + casesSameCasesModel.getId() + ".webp").into(arizonaCasesSameCasesItemBinding.ivPrize);
            arizonaCasesSameCasesItemBinding.tvPrizeCost.setText(String.valueOf(casesSameCasesModel.getCost()));
            TextView tvPrizeCost = arizonaCasesSameCasesItemBinding.tvPrizeCost;
            Intrinsics.checkNotNullExpressionValue(tvPrizeCost, "tvPrizeCost");
            tvPrizeCost.setVisibility(casesSameCasesModel.getCost() <= 0 ? 8 : 0);
            ImageView ivRub = arizonaCasesSameCasesItemBinding.ivRub;
            Intrinsics.checkNotNullExpressionValue(ivRub, "ivRub");
            ivRub.setVisibility(casesSameCasesModel.getCost() <= 0 ? 8 : 0);
            arizonaCasesSameCasesItemBinding.tvBenefit.setText(casesSameCasesModel.getBenefitWithPercent());
            TextView tvBenefit = arizonaCasesSameCasesItemBinding.tvBenefit;
            Intrinsics.checkNotNullExpressionValue(tvBenefit, "tvBenefit");
            tvBenefit.setVisibility(8);
            TextView tvTop = arizonaCasesSameCasesItemBinding.tvTop;
            Intrinsics.checkNotNullExpressionValue(tvTop, "tvTop");
            tvTop.setVisibility(8);
            TextView tvNew = arizonaCasesSameCasesItemBinding.tvNew;
            Intrinsics.checkNotNullExpressionValue(tvNew, "tvNew");
            tvNew.setVisibility(8);
            for (CasesBadgesModel casesBadgesModel : casesSameCasesModel.getBadges()) {
                if (Intrinsics.areEqual(casesBadgesModel.getStyle(), CasesSameCasesAdapter.BENEFIT)) {
                    TextView tvBenefit2 = arizonaCasesSameCasesItemBinding.tvBenefit;
                    Intrinsics.checkNotNullExpressionValue(tvBenefit2, "tvBenefit");
                    tvBenefit2.setVisibility(0);
                }
                if (Intrinsics.areEqual(casesBadgesModel.getStyle(), CasesSameCasesAdapter.TOP)) {
                    TextView tvTop2 = arizonaCasesSameCasesItemBinding.tvTop;
                    Intrinsics.checkNotNullExpressionValue(tvTop2, "tvTop");
                    tvTop2.setVisibility(0);
                }
                if (Intrinsics.areEqual(casesBadgesModel.getStyle(), CasesSameCasesAdapter.NEW)) {
                    TextView tvNew2 = arizonaCasesSameCasesItemBinding.tvNew;
                    Intrinsics.checkNotNullExpressionValue(tvNew2, "tvNew");
                    tvNew2.setVisibility(0);
                }
            }
            int i = WhenMappings.$EnumSwitchMapping$0[casesSameCasesModel.m12065getCurrency().ordinal()];
            if (i == 1) {
                arizonaCasesSameCasesItemBinding.ivRub.setImageResource(R.drawable.blueprint_ic_rub);
                arizonaCasesSameCasesItemBinding.ivRub.setImageTintList(ColorStateList.valueOf(Color.parseColor("#95FF00")));
            } else if (i != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                arizonaCasesSameCasesItemBinding.ivRub.setImageResource(R.drawable.ic_az_coins);
                arizonaCasesSameCasesItemBinding.ivRub.setImageTintList(null);
            }
        }

        private final void setupListeners(final int i) {
            FrameLayout root = this.binding.getRoot();
            final CasesSameCasesAdapter casesSameCasesAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.adapters.CasesSameCasesAdapter$SameCasesViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CasesSameCasesAdapter.SameCasesViewHolder.setupListeners$lambda$0(CasesSameCasesAdapter.this, i, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0(CasesSameCasesAdapter casesSameCasesAdapter, int i, View view) {
            casesSameCasesAdapter.getOnClick().invoke(Integer.valueOf(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SameCasesViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ArizonaCasesSameCasesItemBinding inflate = ArizonaCasesSameCasesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SameCasesViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SameCasesViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CasesSameCasesModel casesSameCasesModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(casesSameCasesModel, "get(...)");
        holder.onBind(casesSameCasesModel);
    }

    /* compiled from: CasesSameCasesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesSameCasesAdapter$Companion;", "", "<init>", "()V", "BENEFIT", "", "TOP", "NEW", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: CasesSameCasesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesSameCasesAdapter$DiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/mrlargha/feature/arizona/cases/CasesSameCasesModel;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class DiffUtilCallback extends DiffUtil.ItemCallback<CasesSameCasesModel> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CasesSameCasesModel oldItem, CasesSameCasesModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CasesSameCasesModel oldItem, CasesSameCasesModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
