package ru.mrlargha.feature.battlepassWinter2025;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.UpdateServiceContract;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.battlepassWinter2025.data.CategoryType;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLayoutBinding;
/* compiled from: BattlePassUi.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020'2\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020.H\u0016J\u0018\u00102\u001a\u0002002\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020.H\u0016J \u00105\u001a\u00020'2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020.H\u0016J@\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020!2\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020.2\u0006\u0010A\u001a\u00020.H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020!X¤\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#¨\u0006B"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BindingBattlePassUi;", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassUi;", "context", "Landroid/content/Context;", "host", "Landroid/view/View;", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;", "itemLayouts", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassItemLayouts;", "navigation", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationViews;", "mainPage", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassMainPageViews;", "tasksPage", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassTasksPageViews;", "<init>", "(Landroid/content/Context;Landroid/view/View;Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;Lru/mrlargha/feature/battlepassWinter2025/BattlePassItemLayouts;Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationViews;Lru/mrlargha/feature/battlepassWinter2025/BattlePassMainPageViews;Lru/mrlargha/feature/battlepassWinter2025/BattlePassTasksPageViews;)V", "getContext", "()Landroid/content/Context;", "getHost", "()Landroid/view/View;", "getBinding", "()Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;", "getItemLayouts", "()Lru/mrlargha/feature/battlepassWinter2025/BattlePassItemLayouts;", "getNavigation", "()Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationViews;", "getMainPage", "()Lru/mrlargha/feature/battlepassWinter2025/BattlePassMainPageViews;", "getTasksPage", "()Lru/mrlargha/feature/battlepassWinter2025/BattlePassTasksPageViews;", "keepInactiveNavigationOpaque", "", "getKeepInactiveNavigationOpaque", "()Z", "keepMainNavigationSelectedOnSecondaryPages", "getKeepMainNavigationSelectedOnSecondaryPages", "prepare", "", "setChromeVisible", "visible", "setMainPageControlsVisible", "setTasksPageVisible", "bindCompletedLevel", "completedLevel", "", "formatAzCoins", "", "amount", "formatExperience", UpdateServiceContract.BundleKey.CURRENT, "maximum", "applyTaskCategoryState", "selectedCategory", "Lru/mrlargha/feature/battlepassWinter2025/data/CategoryType;", "activeTextColor", "inactiveTextColor", "applyNavigationState", TtmlNode.RUBY_CONTAINER, "text", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "selected", "selectedBackgroundColor", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class BindingBattlePassUi implements BattlePassUi {
    private final WinterBattlepassLayoutBinding binding;
    private final Context context;
    private final View host;
    private final BattlePassItemLayouts itemLayouts;
    private final boolean keepMainNavigationSelectedOnSecondaryPages;
    private final BattlePassMainPageViews mainPage;
    private final BattlePassNavigationViews navigation;
    private final BattlePassTasksPageViews tasksPage;

    protected abstract boolean getKeepInactiveNavigationOpaque();

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void prepare() {
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void setChromeVisible(boolean z) {
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void setMainPageControlsVisible(boolean z) {
    }

    public BindingBattlePassUi(Context context, View host, WinterBattlepassLayoutBinding binding, BattlePassItemLayouts itemLayouts, BattlePassNavigationViews navigation, BattlePassMainPageViews mainPage, BattlePassTasksPageViews tasksPage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(itemLayouts, "itemLayouts");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(mainPage, "mainPage");
        Intrinsics.checkNotNullParameter(tasksPage, "tasksPage");
        this.context = context;
        this.host = host;
        this.binding = binding;
        this.itemLayouts = itemLayouts;
        this.navigation = navigation;
        this.mainPage = mainPage;
        this.tasksPage = tasksPage;
    }

    protected final Context getContext() {
        return this.context;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public final View getHost() {
        return this.host;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public final WinterBattlepassLayoutBinding getBinding() {
        return this.binding;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public final BattlePassItemLayouts getItemLayouts() {
        return this.itemLayouts;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public final BattlePassNavigationViews getNavigation() {
        return this.navigation;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public final BattlePassMainPageViews getMainPage() {
        return this.mainPage;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public final BattlePassTasksPageViews getTasksPage() {
        return this.tasksPage;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public boolean getKeepMainNavigationSelectedOnSecondaryPages() {
        return this.keepMainNavigationSelectedOnSecondaryPages;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void setTasksPageVisible(boolean z) {
        this.tasksPage.getRoot().setVisibility(z ? 0 : 8);
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void bindCompletedLevel(int i) {
        LinearLayout bpLevel = this.binding.bpLevel;
        Intrinsics.checkNotNullExpressionValue(bpLevel, "bpLevel");
        bpLevel.setVisibility(i <= 100 ? 4 : 0);
        this.binding.tvBpLevel.setText(String.valueOf(i));
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public String formatAzCoins(int i) {
        return String.valueOf(i);
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public String formatExperience(int i, int i2) {
        return i + "/" + i2;
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void applyTaskCategoryState(CategoryType selectedCategory, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        for (Map.Entry<CategoryType, BattlePassTaskCategoryViews> entry : this.tasksPage.getCategories().entrySet()) {
            CategoryType key = entry.getKey();
            BattlePassTaskCategoryViews value = entry.getValue();
            boolean z = key == selectedCategory;
            if (z) {
                i3 = R.drawable.background_az_battlepass_type_task_enabled;
            } else if (key == CategoryType.PREMIUM) {
                i3 = R.drawable.background_az_battlepass_type_task_premium;
            } else {
                i3 = R.drawable.background_az_battlepass_type_task_disabled;
            }
            value.getContainer().setBackgroundResource(i3);
            value.getText().setTextColor(z ? i : i2);
        }
    }

    @Override // ru.mrlargha.feature.battlepassWinter2025.BattlePassUi
    public void applyNavigationState(View container, TextView text, ImageView icon, boolean z, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        if (!z) {
            i = i2;
        }
        container.setAlpha((getKeepInactiveNavigationOpaque() || z) ? 1.0f : 0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.context.getResources().getDimension(ru.mrlargha.commonui.R.dimen._4sdp));
        if (!z) {
            i3 = 0;
        }
        gradientDrawable.setColor(i3);
        container.setBackground(gradientDrawable);
        text.setTextColor(i);
        icon.setImageTintList(ColorStateList.valueOf(i));
    }
}
