package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.WinterBattlepassRoulettePriseItemBinding;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.PriseAdapter;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.data.PossiblePrise;
/* compiled from: PriseAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#Bi\u0012`\u0010\u0003\u001a\\\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0013\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0012J\u0014\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000bH\u0007J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u000bH\u0016Rh\u0010\u0003\u001a\\\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/PriseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/PriseAdapter$PriseViewHolder;", "showName", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "offsetX", "offsetY", "", "", "width", "", "<init>", "(Lkotlin/jvm/functions/Function4;)V", "priseList", "", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/data/PossiblePrise;", "clearPriseList", "addPrise", "prise", "setData", "data", "", "changePrise", "targetPrise", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "PriseViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PriseAdapter extends RecyclerView.Adapter<PriseViewHolder> {
    private List<PossiblePrise> priseList;
    private final Function4<Float, Float, String, Integer, Unit> showName;

    /* JADX WARN: Multi-variable type inference failed */
    public PriseAdapter(Function4<? super Float, ? super Float, ? super String, ? super Integer, Unit> showName) {
        Intrinsics.checkNotNullParameter(showName, "showName");
        this.showName = showName;
        this.priseList = new ArrayList();
    }

    public final void clearPriseList() {
        this.priseList.clear();
        notifyDataSetChanged();
    }

    public final void addPrise(PossiblePrise prise) {
        Intrinsics.checkNotNullParameter(prise, "prise");
        this.priseList.add(prise);
        notifyDataSetChanged();
    }

    public final void setData(List<PossiblePrise> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.priseList = CollectionsKt.toMutableList((Collection) data);
    }

    public final void changePrise(int i) {
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.priseList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PriseViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.winter_battlepass_roulette_prise_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new PriseViewHolder(inflate, this.showName);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PriseViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.priseList.get(i));
    }

    /* compiled from: PriseAdapter.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012`\u0010\u0004\u001a\\\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015Rh\u0010\u0004\u001a\\\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/PriseAdapter$PriseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "showName", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "offsetX", "offsetY", "", "", "width", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function4;)V", "binding", "Lru/mrlargha/commonui/databinding/WinterBattlepassRoulettePriseItemBinding;", "bind", "prise", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/data/PossiblePrise;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PriseViewHolder extends RecyclerView.ViewHolder {
        private final WinterBattlepassRoulettePriseItemBinding binding;
        private final Function4<Float, Float, String, Integer, Unit> showName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PriseViewHolder(View itemView, Function4<? super Float, ? super Float, ? super String, ? super Integer, Unit> showName) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(showName, "showName");
            this.showName = showName;
            WinterBattlepassRoulettePriseItemBinding bind = WinterBattlepassRoulettePriseItemBinding.bind(itemView);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final void bind(final PossiblePrise prise) {
            int i;
            String str;
            Intrinsics.checkNotNullParameter(prise, "prise");
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.PriseAdapter$PriseViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PriseAdapter.PriseViewHolder.bind$lambda$0(PriseAdapter.PriseViewHolder.this, prise, view);
                }
            });
            String rarity = prise.getRarity();
            switch (rarity.hashCode()) {
                case -976943172:
                    if (rarity.equals("purple")) {
                        i = R.drawable.rarity_purple;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 112785:
                    if (rarity.equals("red")) {
                        i = R.drawable.rarity_red;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 3002044:
                    if (rarity.equals("aqua")) {
                        i = R.drawable.rarity_aqua;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 3178592:
                    if (rarity.equals("gold")) {
                        i = R.drawable.rarity_gold;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 3441014:
                    if (rarity.equals("pink")) {
                        i = R.drawable.rarity_pink;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                default:
                    i = R.drawable.rarity_default;
                    break;
            }
            String rarity2 = prise.getRarity();
            switch (rarity2.hashCode()) {
                case -976943172:
                    if (rarity2.equals("purple")) {
                        str = "#6881FF";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 112785:
                    if (rarity2.equals("red")) {
                        str = "#FF3600";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 3002044:
                    if (rarity2.equals("aqua")) {
                        str = "#6FF5FF";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 3178592:
                    if (rarity2.equals("gold")) {
                        str = "#FFBA00";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 3441014:
                    if (rarity2.equals("pink")) {
                        str = "#E500FF";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                default:
                    str = "#FFFFFF";
                    break;
            }
            this.binding.bg.setBackgroundResource(i);
            this.binding.rarity.setBackgroundColor(Color.parseColor(str));
            this.binding.imagePrise.setImageBitmap(RoulettePrisesPicasso.INSTANCE.getBitmap(prise.getImage()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(PriseViewHolder priseViewHolder, PossiblePrise possiblePrise, View view) {
            int[] iArr = new int[2];
            priseViewHolder.itemView.getLocationOnScreen(iArr);
            priseViewHolder.showName.invoke(Float.valueOf((float) (iArr[0] + (priseViewHolder.itemView.getWidth() * 0.1d))), Float.valueOf((float) (iArr[1] + (priseViewHolder.itemView.getHeight() * 0.8d))), possiblePrise.getTitle(), Integer.valueOf(priseViewHolder.itemView.getWidth()));
        }
    }
}
