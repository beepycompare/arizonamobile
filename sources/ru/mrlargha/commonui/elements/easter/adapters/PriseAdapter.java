package ru.mrlargha.commonui.elements.easter.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.EasterBattlepassPriseItemBinding;
import ru.mrlargha.commonui.elements.easter.adapters.PriseAdapter;
import ru.mrlargha.commonui.elements.easter.data.EasterItem;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: PriseAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0012\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\t2\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0016H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\fR#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/easter/adapters/PriseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/easter/adapters/PriseAdapter$OldPriseViewHolder;", "isArizona", "", "onClick", "Lkotlin/Function2;", "", "Landroid/view/View;", "", "<init>", "(ZLkotlin/jvm/functions/Function2;)V", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "priseList", "", "Lru/mrlargha/commonui/elements/easter/data/EasterItem;", "setPriseList", "list", "", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "OldPriseViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PriseAdapter extends RecyclerView.Adapter<OldPriseViewHolder> {
    private final boolean isArizona;
    private final Function2<String, View, Unit> onClick;
    private List<EasterItem> priseList;

    public final Function2<String, View, Unit> getOnClick() {
        return this.onClick;
    }

    public final boolean isArizona() {
        return this.isArizona;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriseAdapter(boolean z, Function2<? super String, ? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.isArizona = z;
        this.onClick = onClick;
        this.priseList = new ArrayList();
    }

    public final void setPriseList(List<EasterItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.priseList = CollectionsKt.toMutableList((Collection) list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.priseList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OldPriseViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.easter_battlepass_prise_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new OldPriseViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OldPriseViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.priseList.get(i));
    }

    /* compiled from: PriseAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/easter/adapters/PriseAdapter$OldPriseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lru/mrlargha/commonui/elements/easter/adapters/PriseAdapter;Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/EasterBattlepassPriseItemBinding;", "bind", "", "prise", "Lru/mrlargha/commonui/elements/easter/data/EasterItem;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class OldPriseViewHolder extends RecyclerView.ViewHolder {
        private final EasterBattlepassPriseItemBinding binding;
        final /* synthetic */ PriseAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OldPriseViewHolder(PriseAdapter priseAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = priseAdapter;
            EasterBattlepassPriseItemBinding bind = EasterBattlepassPriseItemBinding.bind(itemView);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final void bind(final EasterItem prise) {
            int i;
            String str;
            Intrinsics.checkNotNullParameter(prise, "prise");
            String color = prise.getColor();
            switch (color.hashCode()) {
                case -976943172:
                    if (color.equals("purple")) {
                        i = R.drawable.rarity_purple;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 112785:
                    if (color.equals("red")) {
                        i = R.drawable.rarity_red;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 3002044:
                    if (color.equals("aqua")) {
                        i = R.drawable.rarity_aqua;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 3178592:
                    if (color.equals("gold")) {
                        i = R.drawable.rarity_gold;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                case 3441014:
                    if (color.equals("pink")) {
                        i = R.drawable.rarity_pink;
                        break;
                    }
                    i = R.drawable.rarity_default;
                    break;
                default:
                    i = R.drawable.rarity_default;
                    break;
            }
            String color2 = prise.getColor();
            switch (color2.hashCode()) {
                case -976943172:
                    if (color2.equals("purple")) {
                        str = "#6881FF";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 112785:
                    if (color2.equals("red")) {
                        str = "#FF3600";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 3002044:
                    if (color2.equals("aqua")) {
                        str = "#6FF5FF";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 3178592:
                    if (color2.equals("gold")) {
                        str = "#FFBA00";
                        break;
                    }
                    str = "#FFFFFF";
                    break;
                case 3441014:
                    if (color2.equals("pink")) {
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
            if (this.this$0.isArizona()) {
                Picasso picasso = Picasso.get();
                String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
                picasso.load(resourceUrl + "/projects/arizona-rp/assets/images/donate/" + prise.getItemid() + ".webp").into(this.binding.imagePrise);
            } else {
                Picasso picasso2 = Picasso.get();
                String resourceUrl2 = FirebaseConfigHelper.INSTANCE.getResourceUrl();
                picasso2.load(resourceUrl2 + "/projects/rodina-rp/systems/battlepass/items/" + prise.getItemid() + ".webp").into(this.binding.imagePrise);
            }
            LinearLayout root = this.binding.getRoot();
            final PriseAdapter priseAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.adapters.PriseAdapter$OldPriseViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PriseAdapter.OldPriseViewHolder.bind$lambda$0(PriseAdapter.this, prise, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(PriseAdapter priseAdapter, EasterItem easterItem, View view) {
            Function2<String, View, Unit> onClick = priseAdapter.getOnClick();
            String name = easterItem.getName();
            Intrinsics.checkNotNull(view);
            onClick.invoke(name, view);
        }
    }
}
