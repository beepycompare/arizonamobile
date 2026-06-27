package ru.mrlargha.event.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.event.adapters.PriseAdapter;
import ru.mrlargha.event.data.EasterItem;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesSameCasesAdapter;
import ru.mrlargha.feature.event.R;
import ru.mrlargha.feature.event.databinding.EventPriseItemBinding;
/* compiled from: PriseAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB!\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000f\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u001c\u0010\u0018\u001a\u00020\u00072\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0013H\u0016R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/event/adapters/PriseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/event/adapters/PriseAdapter$OldPriseViewHolder;", "onClick", "Lkotlin/Function2;", "", "Landroid/view/View;", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "priseList", "", "Lru/mrlargha/event/data/EasterItem;", "setPriseList", "list", "", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "OldPriseViewHolder", "event"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PriseAdapter extends RecyclerView.Adapter<OldPriseViewHolder> {
    private final Function2<String, View, Unit> onClick;
    private List<EasterItem> priseList;

    /* JADX WARN: Multi-variable type inference failed */
    public PriseAdapter(Function2<? super String, ? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.priseList = new ArrayList();
    }

    public final Function2<String, View, Unit> getOnClick() {
        return this.onClick;
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
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_prise_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new OldPriseViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OldPriseViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.priseList.get(i));
    }

    /* compiled from: PriseAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/mrlargha/event/adapters/PriseAdapter$OldPriseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lru/mrlargha/event/adapters/PriseAdapter;Landroid/view/View;)V", "binding", "Lru/mrlargha/feature/event/databinding/EventPriseItemBinding;", "bind", "", "prise", "Lru/mrlargha/event/data/EasterItem;", "event"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class OldPriseViewHolder extends RecyclerView.ViewHolder {
        private final EventPriseItemBinding binding;
        final /* synthetic */ PriseAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OldPriseViewHolder(PriseAdapter priseAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = priseAdapter;
            EventPriseItemBinding bind = EventPriseItemBinding.bind(itemView);
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
                        i = ru.mrlargha.commonui.R.drawable.rarity_purple;
                        break;
                    }
                    i = ru.mrlargha.commonui.R.drawable.rarity_default;
                    break;
                case 112785:
                    if (color.equals(CasesSameCasesAdapter.NEW)) {
                        i = ru.mrlargha.commonui.R.drawable.rarity_red;
                        break;
                    }
                    i = ru.mrlargha.commonui.R.drawable.rarity_default;
                    break;
                case 3002044:
                    if (color.equals("aqua")) {
                        i = ru.mrlargha.commonui.R.drawable.rarity_aqua;
                        break;
                    }
                    i = ru.mrlargha.commonui.R.drawable.rarity_default;
                    break;
                case 3178592:
                    if (color.equals("gold")) {
                        i = ru.mrlargha.commonui.R.drawable.rarity_gold;
                        break;
                    }
                    i = ru.mrlargha.commonui.R.drawable.rarity_default;
                    break;
                case 3441014:
                    if (color.equals("pink")) {
                        i = ru.mrlargha.commonui.R.drawable.rarity_pink;
                        break;
                    }
                    i = ru.mrlargha.commonui.R.drawable.rarity_default;
                    break;
                default:
                    i = ru.mrlargha.commonui.R.drawable.rarity_default;
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
                    if (color2.equals(CasesSameCasesAdapter.NEW)) {
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
            if (UtilsKt.isArizonaType()) {
                Picasso picasso = Picasso.get();
                String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
                picasso.load(projectResourceUrl$default + "/assets/images/donate/" + prise.getItemid() + ".webp").into(this.binding.imagePrise);
            } else {
                Picasso picasso2 = Picasso.get();
                String projectResourceUrl$default2 = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
                picasso2.load(projectResourceUrl$default2 + "systems/pirate-event/rewards/" + prise.getItemid() + ".webp").into(this.binding.imagePrise);
            }
            LinearLayout root = this.binding.getRoot();
            final PriseAdapter priseAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.adapters.PriseAdapter$OldPriseViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PriseAdapter.OldPriseViewHolder.bind$lambda$0(PriseAdapter.this, prise, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void bind$lambda$0(PriseAdapter priseAdapter, EasterItem easterItem, View view) {
            Function2<String, View, Unit> onClick = priseAdapter.getOnClick();
            String name = easterItem.getName();
            Intrinsics.checkNotNull(view);
            onClick.invoke(name, view);
        }
    }
}
