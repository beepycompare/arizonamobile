package ru.mrlargha.feature.battlepassWinter2025;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.UpdateServiceContract;
import kotlin.Metadata;
import ru.mrlargha.feature.battlepassWinter2025.data.CategoryType;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassLayoutBinding;
/* compiled from: BattlePassUi.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH&J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH&J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH&J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&H&J\u0018\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020&H&J \u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020&H&J@\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001b2\u0006\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020&2\u0006\u00109\u001a\u00020&H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006:À\u0006\u0003"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/BattlePassUi;", "", "host", "Landroid/view/View;", "getHost", "()Landroid/view/View;", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;", "getBinding", "()Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassLayoutBinding;", "itemLayouts", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassItemLayouts;", "getItemLayouts", "()Lru/mrlargha/feature/battlepassWinter2025/BattlePassItemLayouts;", "navigation", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationViews;", "getNavigation", "()Lru/mrlargha/feature/battlepassWinter2025/BattlePassNavigationViews;", "mainPage", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassMainPageViews;", "getMainPage", "()Lru/mrlargha/feature/battlepassWinter2025/BattlePassMainPageViews;", "tasksPage", "Lru/mrlargha/feature/battlepassWinter2025/BattlePassTasksPageViews;", "getTasksPage", "()Lru/mrlargha/feature/battlepassWinter2025/BattlePassTasksPageViews;", "keepMainNavigationSelectedOnSecondaryPages", "", "getKeepMainNavigationSelectedOnSecondaryPages", "()Z", "prepare", "", "setChromeVisible", "visible", "setMainPageControlsVisible", "setTasksPageVisible", "bindCompletedLevel", "completedLevel", "", "formatAzCoins", "", "amount", "formatExperience", UpdateServiceContract.BundleKey.CURRENT, "maximum", "applyTaskCategoryState", "selectedCategory", "Lru/mrlargha/feature/battlepassWinter2025/data/CategoryType;", "activeTextColor", "inactiveTextColor", "applyNavigationState", TtmlNode.RUBY_CONTAINER, "text", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "selected", "selectedBackgroundColor", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface BattlePassUi {
    void applyNavigationState(View view, TextView textView, ImageView imageView, boolean z, int i, int i2, int i3);

    void applyTaskCategoryState(CategoryType categoryType, int i, int i2);

    void bindCompletedLevel(int i);

    String formatAzCoins(int i);

    String formatExperience(int i, int i2);

    WinterBattlepassLayoutBinding getBinding();

    View getHost();

    BattlePassItemLayouts getItemLayouts();

    boolean getKeepMainNavigationSelectedOnSecondaryPages();

    BattlePassMainPageViews getMainPage();

    BattlePassNavigationViews getNavigation();

    BattlePassTasksPageViews getTasksPage();

    void prepare();

    void setChromeVisible(boolean z);

    void setMainPageControlsVisible(boolean z);

    void setTasksPageVisible(boolean z);
}
