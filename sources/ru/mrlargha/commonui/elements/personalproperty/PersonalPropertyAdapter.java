package ru.mrlargha.commonui.elements.personalproperty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.RodinaPersonalPropertyItemViewBinding;
/* compiled from: PersonalPropertyAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyDetail;", "Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyAdapter$PersonalPropertyDetailViewHolder;", "details", "", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "PersonalPropertyDetailViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonalPropertyAdapter extends ListAdapter<PersonalPropertyDetail, PersonalPropertyDetailViewHolder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalPropertyAdapter(List<PersonalPropertyDetail> details) {
        super(new DiffUtil.ItemCallback<PersonalPropertyDetail>() { // from class: ru.mrlargha.commonui.elements.personalproperty.PersonalPropertyAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(PersonalPropertyDetail oldItem, PersonalPropertyDetail newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(PersonalPropertyDetail oldItem, PersonalPropertyDetail newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(details, "details");
        submitList(details);
    }

    /* compiled from: PersonalPropertyAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyAdapter$PersonalPropertyDetailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/RodinaPersonalPropertyItemViewBinding;", "bind", "", "personalPropertyDetail", "Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyDetail;", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PersonalPropertyDetailViewHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion(null);
        private final RodinaPersonalPropertyItemViewBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PersonalPropertyDetailViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            RodinaPersonalPropertyItemViewBinding bind = RodinaPersonalPropertyItemViewBinding.bind(itemView);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final void bind(PersonalPropertyDetail personalPropertyDetail) {
            Intrinsics.checkNotNullParameter(personalPropertyDetail, "personalPropertyDetail");
            RodinaPersonalPropertyItemViewBinding rodinaPersonalPropertyItemViewBinding = this.binding;
            rodinaPersonalPropertyItemViewBinding.rodinaPersonalPropertyItemViewKey.setText(personalPropertyDetail.getTitle());
            rodinaPersonalPropertyItemViewBinding.rodinaPersonalPropertyItemViewValue.setText(personalPropertyDetail.getValue());
        }

        /* compiled from: PersonalPropertyAdapter.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyAdapter$PersonalPropertyDetailViewHolder$Companion;", "", "<init>", "()V", "create", "Lru/mrlargha/commonui/elements/personalproperty/PersonalPropertyAdapter$PersonalPropertyDetailViewHolder;", "parent", "Landroid/view/ViewGroup;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PersonalPropertyDetailViewHolder create(ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                LinearLayout root = RodinaPersonalPropertyItemViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false).getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                return new PersonalPropertyDetailViewHolder(root);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PersonalPropertyDetailViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return PersonalPropertyDetailViewHolder.Companion.create(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PersonalPropertyDetailViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PersonalPropertyDetail item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }
}
