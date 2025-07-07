package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteAdapter;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.data.PossiblePrise;
/* compiled from: RouletteAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f !B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\tH\u0007J\b\u0010\u0011\u001a\u00020\u0005H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onSellPrise", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "prise", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/PriseModel;", "isPremium", "", "()Z", "setPremium", "(Z)V", "changePrise", "targetPrise", "notifyAdapter", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "rarityBg", "rarity", "", "getItemViewType", "PriseViewHolder", "InfoPriseViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RouletteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion(null);
    public static final int INFO_PRISE_TYPE = 2;
    public static final int ITEM_COUNT = 3000;
    public static final int PRISE_TYPE = 1;
    private boolean isPremium;
    private final Function0<Unit> onSellPrise;
    private PriseModel prise;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 3000;
    }

    public RouletteAdapter(Function0<Unit> onSellPrise) {
        Intrinsics.checkNotNullParameter(onSellPrise, "onSellPrise");
        this.onSellPrise = onSellPrise;
    }

    public final boolean isPremium() {
        return this.isPremium;
    }

    public final void setPremium(boolean z) {
        this.isPremium = z;
    }

    public final void changePrise(PriseModel targetPrise) {
        Intrinsics.checkNotNullParameter(targetPrise, "targetPrise");
        this.prise = targetPrise;
        notifyDataSetChanged();
    }

    public final void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        InfoPriseViewHolder infoPriseViewHolder;
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.winter_battlepass_roulette_item, parent, false);
        if (this.isPremium) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, RouletteViewKt.dpToPx(context, 60.0f)));
        }
        View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.winter_battlepass_roulette_prise_info_item, parent, false);
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.winter_battlepass_roulette_premiun_prise_info_item, parent, false);
        if (i == 2) {
            if (this.isPremium) {
                Intrinsics.checkNotNull(inflate3);
                infoPriseViewHolder = new InfoPriseViewHolder(this, inflate3);
            } else {
                Intrinsics.checkNotNull(inflate2);
                infoPriseViewHolder = new InfoPriseViewHolder(this, inflate2);
            }
            return infoPriseViewHolder;
        }
        Intrinsics.checkNotNull(inflate);
        return new PriseViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof InfoPriseViewHolder) {
            ((InfoPriseViewHolder) holder).bind(this.prise);
        } else if (holder instanceof PriseViewHolder) {
            ((PriseViewHolder) holder).bind(this.prise);
        }
    }

    /* compiled from: RouletteAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteAdapter$PriseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteAdapter;Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getImageView", "()Landroid/widget/ImageView;", "bgView", "getBgView", "bind", "", "prise", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/PriseModel;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class PriseViewHolder extends RecyclerView.ViewHolder {
        private final ImageView bgView;
        private final ImageView imageView;
        final /* synthetic */ RouletteAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PriseViewHolder(RouletteAdapter rouletteAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = rouletteAdapter;
            this.imageView = (ImageView) itemView.findViewById(R.id.prise);
            this.bgView = (ImageView) itemView.findViewById(R.id.priseBg);
        }

        public final ImageView getImageView() {
            return this.imageView;
        }

        public final ImageView getBgView() {
            return this.bgView;
        }

        public final void bind(PriseModel priseModel) {
            this.itemView.setOnClickListener(null);
            PossiblePrise randomItem = RoulettePrisesPicasso.INSTANCE.randomItem();
            if (randomItem != null) {
                RouletteAdapter rouletteAdapter = this.this$0;
                this.bgView.setImageResource(rouletteAdapter.rarityBg(randomItem.getRarity()));
                if (getAdapterPosition() == 2 && priseModel != null) {
                    PossiblePrise item = RoulettePrisesPicasso.INSTANCE.getItem(priseModel.getId());
                    if (item != null) {
                        this.bgView.setImageResource(rouletteAdapter.rarityBg(item.getRarity()));
                        this.imageView.setImageBitmap(RoulettePrisesPicasso.INSTANCE.getBitmap(item.getImage()));
                        return;
                    }
                    return;
                }
                this.imageView.setImageBitmap(RoulettePrisesPicasso.INSTANCE.getBitmap(randomItem.getImage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int rarityBg(String str) {
        switch (str.hashCode()) {
            case -976943172:
                if (str.equals("purple")) {
                    return R.drawable.battlepass_2025_winter_roulette_prise_bg_purple;
                }
                break;
            case 112785:
                if (str.equals("red")) {
                    return R.drawable.battlepass_2025_winter_roulette_prise_bg_red;
                }
                break;
            case 3002044:
                if (str.equals("aqua")) {
                    return R.drawable.battlepass_2025_winter_roulette_prise_bg_aqua;
                }
                break;
            case 3178592:
                if (str.equals("gold")) {
                    return R.drawable.battlepass_2025_winter_roulette_prise_bg_gold;
                }
                break;
            case 3441014:
                if (str.equals("pink")) {
                    return R.drawable.battlepass_2025_winter_roulette_prise_bg_pink;
                }
                break;
        }
        return R.drawable.rarity_default;
    }

    /* compiled from: RouletteAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteAdapter$InfoPriseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteAdapter;Landroid/view/View;)V", "bind", "", "prise", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/PriseModel;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class InfoPriseViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ RouletteAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InfoPriseViewHolder(RouletteAdapter rouletteAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = rouletteAdapter;
        }

        public final void bind(PriseModel priseModel) {
            if (priseModel != null) {
                final RouletteAdapter rouletteAdapter = this.this$0;
                final LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R.id.btn_sell_prise);
                final LinearLayout linearLayout2 = (LinearLayout) this.itemView.findViewById(R.id.selled_prise);
                linearLayout.setVisibility(0);
                linearLayout2.setVisibility(8);
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteAdapter$InfoPriseViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RouletteAdapter.InfoPriseViewHolder.bind$lambda$1$lambda$0(RouletteAdapter.this, linearLayout, linearLayout2, view);
                    }
                });
                TextView textView = (TextView) this.itemView.findViewById(R.id.tv_prise_name);
                PossiblePrise item = RoulettePrisesPicasso.INSTANCE.getItem(priseModel.getId());
                textView.setText((item == null || (r1 = item.getTitle()) == null) ? "" : "");
                TextView textView2 = (TextView) this.itemView.findViewById(R.id.price_prise);
                PossiblePrise item2 = RoulettePrisesPicasso.INSTANCE.getItem(priseModel.getId());
                textView2.setText(String.valueOf(item2 != null ? item2.getPrice() : 0));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1$lambda$0(RouletteAdapter rouletteAdapter, LinearLayout linearLayout, LinearLayout linearLayout2, View view) {
            rouletteAdapter.onSellPrise.invoke();
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (i != 3 || this.prise == null) ? 1 : 2;
    }

    /* compiled from: RouletteAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RouletteAdapter$Companion;", "", "<init>", "()V", "ITEM_COUNT", "", "INFO_PRISE_TYPE", "PRISE_TYPE", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
