package ru.mrlargha.employment.center;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.employment.center.data.EmploymentData;
import ru.mrlargha.feature.employment.center.R;
import ru.mrlargha.feature.employment.center.databinding.EmploymentCenterListItemBinding;
/* compiled from: JobsAdapter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\u0014\u0010\u001c\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eJ\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u0004J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lru/mrlargha/employment/center/JobsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/employment/center/EmploymentItemViewHolder;", "onSelect", "Lkotlin/Function1;", "Lru/mrlargha/employment/center/Job;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "value", "", "selected", "getSelected", "()I", FirebaseAnalytics.Param.LEVEL, "job", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", "items", "", "select", "id", "scroll", "setInfo", "info", "Lru/mrlargha/employment/center/data/EmploymentData;", "clearList", "employment-center"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class JobsAdapter extends RecyclerView.Adapter<EmploymentItemViewHolder> {
    private final List<Job> itemsList;
    private int job;
    private int level;
    private final Function1<Job, Unit> onSelect;
    private int selected;

    /* JADX WARN: Multi-variable type inference failed */
    public JobsAdapter(Function1<? super Job, Unit> onSelect) {
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        this.onSelect = onSelect;
        this.itemsList = new ArrayList();
        this.job = -1;
    }

    public final List<Job> getItemsList() {
        return this.itemsList;
    }

    public final int getSelected() {
        return this.selected;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EmploymentItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.employment_center_list_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new EmploymentItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EmploymentItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final Job job = (Job) CollectionsKt.getOrNull(this.itemsList, i);
        if (job == null) {
            job = (Job) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        EmploymentCenterListItemBinding binding = holder.getBinding();
        binding.image.setImageResource(EmploymentIconsKt.employmentIcon(job.getIcon()));
        binding.text.setText(job.getName());
        binding.label1.text.setText(String.valueOf(job.getMinLevel()));
        if (this.level >= job.getMinLevel()) {
            binding.label1.getRoot().setBackground(Color.parseColor("#151515"));
            binding.label1.text.setTextColor(Color.parseColor("#D9FFFFFF"));
            binding.label1.text.setText(holder.itemView.getContext().getString(R.string.employment_level, Integer.valueOf(job.getMinLevel())));
        } else {
            binding.label1.getRoot().setBackground(Color.parseColor("#602121"));
            binding.label1.text.setTextColor(Color.parseColor("#D9FFB7B7"));
            binding.label1.text.setText(holder.itemView.getContext().getString(R.string.employment_required_level, Integer.valueOf(job.getMinLevel())));
        }
        if (this.job == job.getId()) {
            binding.label1.getRoot().setBackground(Color.parseColor("#294B29"));
            binding.label1.text.setTextColor(Color.parseColor("#8DFF8D"));
            binding.label1.text.setText(holder.itemView.getContext().getString(R.string.employment_hired));
        }
        if (job.getBonusSalary().getPercent() == 0) {
            binding.label2.getRoot().setVisibility(8);
        } else {
            binding.label2.getRoot().setVisibility(0);
        }
        binding.label2.getRoot().setBackground(Color.parseColor("#8DFF8D"));
        binding.label2.text.setTextColor(Color.parseColor("#3A693A"));
        binding.label2.text.setText("+" + job.getBonusSalary().getPercent() + "%");
        if (job.getId() == this.selected) {
            CustomCardView root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            CustomCardView.setBorder$default(root, Color.parseColor("#364B84"), Color.parseColor("#CC3048"), null, 4, null);
        } else {
            binding.getRoot().setBorder(0);
        }
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.JobsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JobsAdapter.onBindViewHolder$lambda$0$0(JobsAdapter.this, job, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(JobsAdapter jobsAdapter, Job job, View view) {
        jobsAdapter.selected = job.getId();
        jobsAdapter.onSelect.invoke(job);
        jobsAdapter.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<Job> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        clearList();
        this.itemsList.addAll(items);
        notifyDataSetChanged();
    }

    public final void select(int i, Function1<? super Integer, Unit> scroll) {
        Object obj;
        Intrinsics.checkNotNullParameter(scroll, "scroll");
        this.selected = i;
        if (!this.itemsList.isEmpty()) {
            Iterator<T> it = this.itemsList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Job) obj).getId() == i) {
                    break;
                }
            }
            Job job = (Job) obj;
            if (job != null) {
                this.onSelect.invoke(job);
                scroll.invoke(Integer.valueOf(this.itemsList.indexOf(job)));
            }
        }
        notifyDataSetChanged();
    }

    public final void setInfo(EmploymentData info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.level = info.getPlayerLevel();
        this.job = info.getPlayerJob();
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
