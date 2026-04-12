package ru.mrlargha.employment.center;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.JsonParseException;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.TimeConverterKt;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
import ru.mrlargha.employment.center.data.AdditionalInfo;
import ru.mrlargha.employment.center.data.BonusItem;
import ru.mrlargha.employment.center.data.EmploymentData;
import ru.mrlargha.employment.center.data.JobInfo;
import ru.mrlargha.employment.center.data.SelectJob;
import ru.mrlargha.feature.employment.center.R;
import ru.mrlargha.feature.employment.center.databinding.EmploymentCenterMainBinding;
import ru.mrlargha.feature.employment.center.databinding.EmploymentCenterSalaryTableBinding;
import ru.mrlargha.feature.employment.center.databinding.EmploymentCenterScreenBinding;
/* compiled from: EmploymentScreen.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0003:;<B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0018H\u0002J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010(\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u0016H\u0002J\b\u00103\u001a\u00020 H\u0002J\b\u00104\u001a\u00020 H\u0002J\u0010\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u0006H\u0002J\u0010\u00107\u001a\u00020 2\u0006\u00108\u001a\u000209H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lru/mrlargha/employment/center/EmploymentScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/feature/employment/center/databinding/EmploymentCenterScreenBinding;", "client", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getClient", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "api", "Lru/mrlargha/employment/center/EmploymentApi;", "apiData", "", "Lru/mrlargha/employment/center/Job;", "mainData", "Lru/mrlargha/employment/center/data/EmploymentData;", "jobsAdapter", "Lru/mrlargha/employment/center/JobsAdapter;", "bonusesAdapter", "Lru/mrlargha/employment/center/BonusesAdapter;", "textBonusAdapter", "Lru/mrlargha/employment/center/TextBonusAdapter;", "setVisible", "", "visible", "", "onBackendMessage", "data", "", "subId", "selectJob", "item", "Lru/mrlargha/employment/center/data/SelectJob;", "getApiData", "setMainInfo", "setServerInfo", "info", "Lru/mrlargha/employment/center/data/JobInfo;", "onClickBonus", "Lru/mrlargha/employment/center/data/BonusItem;", "onSelectJob", "job", "setupAdapters", "setupNavigation", "clickJobsButton", "id", "navigateTo", "nav", "Lru/mrlargha/employment/center/EmploymentScreen$Navigation;", "EasterBites", "Navigation", "Spawner", "employment-center"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EmploymentScreen extends SAMPUIElement implements InterfaceController {
    private final EmploymentApi api;
    private List<Job> apiData;
    private final EmploymentCenterScreenBinding binding;
    private final BonusesAdapter bonusesAdapter;
    private final ArizonaRetrofit client;
    private final JobsAdapter jobsAdapter;
    private EmploymentData mainData;
    private final View screen;
    private final TextBonusAdapter textBonusAdapter;

    private final void navigateTo(Navigation navigation) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSelectJob$lambda$0$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupNavigation$lambda$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$1$4(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmploymentScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.employment_center_screen, (ViewGroup) null);
        this.screen = screen;
        EmploymentCenterScreenBinding bind = EmploymentCenterScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.client = arizonaRetrofit;
        this.api = (EmploymentApi) ArizonaRetrofit.create$default(arizonaRetrofit, EmploymentApi.class, false, null, null, 14, null);
        this.apiData = CollectionsKt.emptyList();
        this.mainData = new EmploymentData(0, 0, 0);
        this.jobsAdapter = new JobsAdapter(new Function1() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EmploymentScreen.jobsAdapter$lambda$0(EmploymentScreen.this, (Job) obj);
            }
        });
        this.bonusesAdapter = new BonusesAdapter(new Function1() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EmploymentScreen.bonusesAdapter$lambda$0(EmploymentScreen.this, (BonusItem) obj);
            }
        });
        this.textBonusAdapter = new TextBonusAdapter();
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        setupNavigation();
        setupAdapters();
        getApiData();
    }

    public final ArizonaRetrofit getClient() {
        return this.client;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit jobsAdapter$lambda$0(EmploymentScreen employmentScreen, Job it) {
        Intrinsics.checkNotNullParameter(it, "it");
        employmentScreen.onSelectJob(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit bonusesAdapter$lambda$0(EmploymentScreen employmentScreen, BonusItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        employmentScreen.onClickBonus(it);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        if (this.apiData.isEmpty() && z) {
            getApiData();
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (i == 0) {
                if (MapperKt.isJsonValid(data)) {
                    setMainInfo((EmploymentData) MapperKt.getGson().fromJson(data, (Class<Object>) EmploymentData.class));
                    return;
                }
                throw new JsonParseException("Json is not valid");
            } else if (i == 1) {
                if (MapperKt.isJsonValid(data)) {
                    setServerInfo((JobInfo) MapperKt.getGson().fromJson(data, (Class<Object>) JobInfo.class));
                    return;
                }
                throw new JsonParseException("Json is not valid");
            } else if (i != 2) {
            } else {
                if (MapperKt.isJsonValid(data)) {
                    selectJob((SelectJob) MapperKt.getGson().fromJson(data, (Class<Object>) SelectJob.class));
                    return;
                }
                throw new JsonParseException("Json is not valid");
            }
        } catch (Exception e) {
            Log.d("EmploymentScreen", data + "  " + e.getMessage());
            e.printStackTrace();
            Toast.makeText(getTargetActivity().getApplicationContext(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
        }
    }

    private final void selectJob(SelectJob selectJob) {
        this.jobsAdapter.select(selectJob.getId(), new Function1() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EmploymentScreen.selectJob$lambda$0(EmploymentScreen.this, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit selectJob$lambda$0(EmploymentScreen employmentScreen, int i) {
        employmentScreen.binding.main.rvInfo.scrollToPosition(i);
        return Unit.INSTANCE;
    }

    private final void getApiData() {
        this.binding.main.content.setVisibility(8);
        this.binding.main.loaderBar.setVisibility(0);
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new EmploymentScreen$getApiData$1(this, null), 3, null);
    }

    private final void setMainInfo(EmploymentData employmentData) {
        this.mainData = employmentData;
        this.jobsAdapter.setInfo(employmentData);
    }

    private final void setServerInfo(JobInfo jobInfo) {
        int i;
        this.bonusesAdapter.addAllItems(CollectionsKt.sortedWith(jobInfo.getMyBonusesInfo(), new Comparator() { // from class: ru.mrlargha.employment.center.EmploymentScreen$setServerInfo$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((BonusItem) t2).isShow()), Integer.valueOf(((BonusItem) t).isShow()));
            }
        }));
        ArrayList<BonusItem> arrayList = new ArrayList();
        for (Object obj : jobInfo.getMyBonusesInfo()) {
            BonusItem bonusItem = (BonusItem) obj;
            if (bonusItem.getImageType() != 3 && bonusItem.isShow() == 1) {
                arrayList.add(obj);
            }
        }
        int i2 = 0;
        int i3 = 0;
        for (BonusItem bonusItem2 : arrayList) {
            i3 += bonusItem2.getValue();
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : jobInfo.getMyBonusesInfo()) {
            BonusItem bonusItem3 = (BonusItem) obj2;
            if (bonusItem3.getImageType() == 3 && bonusItem3.isShow() == 1) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (!arrayList3.isEmpty()) {
            Iterator it = arrayList3.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            int value = ((BonusItem) it.next()).getValue();
            while (it.hasNext()) {
                int value2 = ((BonusItem) it.next()).getValue();
                if (value < value2) {
                    value = value2;
                }
            }
            i3 += value;
        }
        EmploymentCenterMainBinding employmentCenterMainBinding = this.binding.main;
        if (jobInfo.getMyBonusesInfo().isEmpty()) {
            employmentCenterMainBinding.bonus.setText("");
            employmentCenterMainBinding.noBonus.setVisibility(0);
        } else {
            employmentCenterMainBinding.bonus.setText("+" + i3 + "%");
            employmentCenterMainBinding.noBonus.setVisibility(8);
        }
        if (jobInfo.getMyBonusesInfo().isEmpty()) {
            employmentCenterMainBinding.buttonBonus.setVisibility(8);
            employmentCenterMainBinding.divider.setVisibility(8);
        } else {
            employmentCenterMainBinding.buttonBonus.setVisibility(0);
            employmentCenterMainBinding.buttonBonus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmploymentScreen.setServerInfo$lambda$5$0(EmploymentScreen.this, view);
                }
            });
            employmentCenterMainBinding.divider.setVisibility(0);
        }
        List<Integer> bites = MapperKt.toBites(jobInfo.getButtonBitsWhite());
        Integer num = (Integer) CollectionsKt.getOrNull(bites, 0);
        if ((num != null ? num.intValue() : 0) == 1) {
            CustomCardView buttonAction1 = employmentCenterMainBinding.buttonAction1;
            Intrinsics.checkNotNullExpressionValue(buttonAction1, "buttonAction1");
            CustomCardView.setBackground$default(buttonAction1, Color.parseColor("#FFFFFF"), Color.parseColor("#999999"), null, null, 12, null);
            employmentCenterMainBinding.buttonAction1text.setTextColor(Color.parseColor("#E6000000"));
        } else {
            employmentCenterMainBinding.buttonAction1text.setTextColor(Color.parseColor("#E6FFFFFF"));
            employmentCenterMainBinding.buttonAction1.setBackground(Color.parseColor("#292929"));
        }
        Integer num2 = (Integer) CollectionsKt.getOrNull(bites, 1);
        if ((num2 != null ? num2.intValue() : 0) == 1) {
            CustomCardView buttonAction2 = employmentCenterMainBinding.buttonAction2;
            Intrinsics.checkNotNullExpressionValue(buttonAction2, "buttonAction2");
            CustomCardView.setBackground$default(buttonAction2, Color.parseColor("#FFFFFF"), Color.parseColor("#999999"), null, null, 12, null);
            employmentCenterMainBinding.buttonAction2text.setTextColor(Color.parseColor("#E6000000"));
        } else {
            employmentCenterMainBinding.buttonAction2text.setTextColor(Color.parseColor("#E6FFFFFF"));
            employmentCenterMainBinding.buttonAction2.setBackground(Color.parseColor("#292929"));
        }
        Integer num3 = (Integer) CollectionsKt.getOrNull(bites, 2);
        if ((num3 != null ? num3.intValue() : 0) == 1) {
            CustomCardView buttonAction3 = employmentCenterMainBinding.buttonAction3;
            Intrinsics.checkNotNullExpressionValue(buttonAction3, "buttonAction3");
            CustomCardView.setBackground$default(buttonAction3, Color.parseColor("#FFFFFF"), Color.parseColor("#999999"), null, null, 12, null);
            employmentCenterMainBinding.buttonAction3text.setTextColor(Color.parseColor("#E6000000"));
        } else {
            employmentCenterMainBinding.buttonAction3text.setTextColor(Color.parseColor("#E6FFFFFF"));
            employmentCenterMainBinding.buttonAction3.setBackground(Color.parseColor("#292929"));
        }
        Integer num4 = (Integer) CollectionsKt.getOrNull(bites, 3);
        if ((num4 != null ? num4.intValue() : 0) == 1) {
            CustomCardView buttonAction4 = employmentCenterMainBinding.buttonAction4;
            Intrinsics.checkNotNullExpressionValue(buttonAction4, "buttonAction4");
            CustomCardView.setBackground$default(buttonAction4, Color.parseColor("#FFFFFF"), Color.parseColor("#999999"), null, null, 12, null);
            employmentCenterMainBinding.buttonAction4text.setTextColor(Color.parseColor("#E6000000"));
        } else {
            employmentCenterMainBinding.buttonAction4text.setTextColor(Color.parseColor("#E6FFFFFF"));
            employmentCenterMainBinding.buttonAction4.setBackground(Color.parseColor("#292929"));
        }
        List<Integer> bites2 = MapperKt.toBites(jobInfo.getButtonBits());
        List<Integer> list = bites2;
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            i = 0;
            for (Number number : list) {
                if ((number.intValue() == 1) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i < 3) {
            employmentCenterMainBinding.buttonAction4text.setText("Информация о работе");
            employmentCenterMainBinding.buttonAction1text.setText("Устроиться на работу");
        } else {
            employmentCenterMainBinding.buttonAction4text.setText("Информация");
            employmentCenterMainBinding.buttonAction1text.setText("Устроиться");
        }
        employmentCenterMainBinding.buttonAction1.setVisibility(8);
        employmentCenterMainBinding.buttonAction2.setVisibility(8);
        employmentCenterMainBinding.buttonAction3.setVisibility(8);
        employmentCenterMainBinding.buttonAction4.setVisibility(8);
        employmentCenterMainBinding.buttonAction5.setVisibility(8);
        Integer num5 = (Integer) CollectionsKt.getOrNull(bites2, 0);
        if ((num5 != null ? num5.intValue() : 0) == 1) {
            employmentCenterMainBinding.buttonAction1.setVisibility(0);
            employmentCenterMainBinding.buttonAction1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmploymentScreen.this.notifyClick(0, 2, "1");
                }
            });
        }
        Integer num6 = (Integer) CollectionsKt.getOrNull(bites2, 1);
        if ((num6 != null ? num6.intValue() : 0) == 1) {
            employmentCenterMainBinding.buttonAction2.setVisibility(0);
            employmentCenterMainBinding.buttonAction2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmploymentScreen.this.notifyClick(0, 2, ExifInterface.GPS_MEASUREMENT_2D);
                }
            });
        }
        Integer num7 = (Integer) CollectionsKt.getOrNull(bites2, 2);
        if ((num7 != null ? num7.intValue() : 0) == 1) {
            employmentCenterMainBinding.buttonAction3.setVisibility(0);
            employmentCenterMainBinding.buttonAction3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmploymentScreen.this.notifyClick(0, 2, "4");
                }
            });
        }
        Integer num8 = (Integer) CollectionsKt.getOrNull(bites2, 3);
        if ((num8 != null ? num8.intValue() : 0) == 1) {
            employmentCenterMainBinding.buttonAction4.setVisibility(0);
            employmentCenterMainBinding.buttonAction4.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmploymentScreen.setServerInfo$lambda$5$5(EmploymentScreen.this, view);
                }
            });
        }
        Integer num9 = (Integer) CollectionsKt.getOrNull(bites2, 4);
        if ((num9 != null ? num9.intValue() : 0) == 1) {
            employmentCenterMainBinding.buttonAction5.setVisibility(0);
        }
        this.textBonusAdapter.addAllItems(jobInfo.getAdditionalInfo());
        EmploymentCenterSalaryTableBinding employmentCenterSalaryTableBinding = this.binding.salaryTable;
        employmentCenterSalaryTableBinding.money.setText(MoneyElementKt.toMoneyFormattedSpannable$default(jobInfo.getHourSalary(), false, null, null, 7, null));
        for (AdditionalInfo additionalInfo : jobInfo.getAdditionalInfo()) {
            i2 += additionalInfo.getValue();
        }
        employmentCenterSalaryTableBinding.totalBonus.setText("+" + i2 + "%");
        long j = i2;
        long j2 = 100;
        employmentCenterSalaryTableBinding.total.setText(MoneyElementKt.toMoneyFormattedSpannable$default(jobInfo.getHourSalary() + ((jobInfo.getHourSalary() * j) / j2), false, null, null, 7, null));
        employmentCenterMainBinding.salary.setText(MoneyElementKt.toMoneyFormattedSpannable$default(jobInfo.getHourSalary() + ((j * jobInfo.getHourSalary()) / j2), false, null, null, 7, null));
        employmentCenterMainBinding.buttonInfo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.setServerInfo$lambda$5$7(EmploymentScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setServerInfo$lambda$5$0(EmploymentScreen employmentScreen, View view) {
        employmentScreen.binding.bonusesTable.getRoot().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setServerInfo$lambda$5$5(EmploymentScreen employmentScreen, View view) {
        employmentScreen.binding.textTable.getRoot().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setServerInfo$lambda$5$7(EmploymentScreen employmentScreen, View view) {
        employmentScreen.binding.salaryTable.getRoot().setVisibility(0);
    }

    private final void onClickBonus(BonusItem bonusItem) {
        if (bonusItem.getDesc().length() > 0) {
            this.binding.bonusDesc.text.setText(bonusItem.getDesc());
            this.binding.bonusDesc.getRoot().setVisibility(0);
            this.binding.bonusDesc.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmploymentScreen.this.binding.bonusDesc.getRoot().setVisibility(8);
                }
            });
        }
    }

    private final void onSelectJob(Job job) {
        EmploymentCenterMainBinding employmentCenterMainBinding = this.binding.main;
        employmentCenterMainBinding.title.setText(job.getName());
        Picasso picasso = Picasso.get();
        String resourceUrl$default = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        picasso.load(resourceUrl$default + "projects/arizona-rp/systems/employment_center/banners/mobile/" + job.getId() + ".webp").into(employmentCenterMainBinding.image);
        employmentCenterMainBinding.labelBonus.setText("+" + job.getBonusSalary().getPercent() + "%");
        employmentCenterMainBinding.timer.setText(TimeConverterKt.taskPageTimeConvert(job.getBonusSalary().getEndUnixTime()));
        if (job.getBonusSalary().getPercent() > 0 || job.getBonusSalary().getEndUnixTime() - System.currentTimeMillis() > 0) {
            employmentCenterMainBinding.label.setVisibility(0);
            if (job.getBonusSalary().getEndUnixTime() == 0) {
                employmentCenterMainBinding.labelTimer.setVisibility(8);
            } else {
                employmentCenterMainBinding.labelTimer.setVisibility(0);
            }
        } else {
            employmentCenterMainBinding.label.setVisibility(8);
        }
        employmentCenterMainBinding.salary.setText(MoneyElementKt.toMoneyFormattedSpannable$default(job.getAvgHourSalary(), false, null, null, 7, null));
        this.binding.textTable.text.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, job.getDescriptionMobile(), 0.0f, 1, null));
        this.binding.textTable.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.onSelectJob$lambda$0$0(view);
            }
        });
        this.binding.textTable.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.onSelectJob$lambda$0$1(EmploymentScreen.this, view);
            }
        });
        this.binding.main.buttonAction1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.onSelectJob$lambda$0$2(EmploymentScreen.this, view);
            }
        });
        employmentCenterMainBinding.buttonAction5text.setText("Необходим " + job.getMinLevel() + " уровень");
        this.binding.main.content.setVisibility(0);
        this.binding.main.loaderBar.setVisibility(8);
        notifyClick(0, 1, String.valueOf(job.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSelectJob$lambda$0$1(EmploymentScreen employmentScreen, View view) {
        employmentScreen.binding.textTable.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSelectJob$lambda$0$2(EmploymentScreen employmentScreen, View view) {
        employmentScreen.binding.textTable.getRoot().setVisibility(0);
    }

    private final void setupAdapters() {
        this.binding.main.rvInfo.setAdapter(this.jobsAdapter);
        this.binding.bonusesTable.rvInfo.setAdapter(this.bonusesAdapter);
        this.binding.salaryTable.rvInfo.setAdapter(this.textBonusAdapter);
    }

    private final void setupNavigation() {
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.setupNavigation$lambda$0(view);
            }
        });
        EmploymentCenterScreenBinding employmentCenterScreenBinding = this.binding;
        employmentCenterScreenBinding.topbar.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.setupNavigation$lambda$1$0(EmploymentScreen.this, view);
            }
        });
        employmentCenterScreenBinding.main.button1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.this.clickJobsButton(0);
            }
        });
        employmentCenterScreenBinding.main.button2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.this.clickJobsButton(1);
            }
        });
        employmentCenterScreenBinding.main.buttonBonus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.setupNavigation$lambda$1$3(EmploymentScreen.this, view);
            }
        });
        employmentCenterScreenBinding.bonusesTable.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.setupNavigation$lambda$1$4(view);
            }
        });
        employmentCenterScreenBinding.bonusesTable.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.setupNavigation$lambda$1$5(EmploymentScreen.this, view);
            }
        });
        employmentCenterScreenBinding.salaryTable.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.employment.center.EmploymentScreen$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmploymentScreen.setupNavigation$lambda$1$6(EmploymentScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$1$0(EmploymentScreen employmentScreen, View view) {
        employmentScreen.getNotifier().setUIElementVisible(employmentScreen.getBackendID(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$1$3(EmploymentScreen employmentScreen, View view) {
        employmentScreen.binding.bonusesTable.getRoot().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$1$5(EmploymentScreen employmentScreen, View view) {
        employmentScreen.binding.bonusesTable.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$1$6(EmploymentScreen employmentScreen, View view) {
        employmentScreen.binding.salaryTable.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickJobsButton(int i) {
        List<Job> list = this.apiData;
        if (i == 0) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Job) obj).getType() == 0) {
                    arrayList.add(obj);
                }
            }
            this.jobsAdapter.addAllItems(arrayList);
            CustomCardView button1 = this.binding.main.button1;
            Intrinsics.checkNotNullExpressionValue(button1, "button1");
            CustomCardView.setBackground$default(button1, Color.parseColor("#FFFFFF"), Color.parseColor("#999999"), null, null, 12, null);
            this.binding.main.button2.setBackground(Color.parseColor("#292929"));
            this.binding.main.text1.setTextColor(Color.parseColor("#E6000000"));
            this.binding.main.text2.setTextColor(Color.parseColor("#E6FFFFFF"));
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (((Job) obj2).getType() == 1) {
                arrayList2.add(obj2);
            }
        }
        this.jobsAdapter.addAllItems(arrayList2);
        CustomCardView button2 = this.binding.main.button2;
        Intrinsics.checkNotNullExpressionValue(button2, "button2");
        CustomCardView.setBackground$default(button2, Color.parseColor("#FFFFFF"), Color.parseColor("#999999"), null, null, 12, null);
        this.binding.main.button1.setBackground(Color.parseColor("#292929"));
        this.binding.main.text2.setTextColor(Color.parseColor("#E6000000"));
        this.binding.main.text1.setTextColor(Color.parseColor("#E6FFFFFF"));
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: EmploymentScreen.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/mrlargha/employment/center/EmploymentScreen$EasterBites;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Main", "employment-center"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class EasterBites {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EasterBites[] $VALUES;
        public static final EasterBites Main = new EasterBites("Main", 0, 1);
        private final int value;

        private static final /* synthetic */ EasterBites[] $values() {
            return new EasterBites[]{Main};
        }

        public static EnumEntries<EasterBites> getEntries() {
            return $ENTRIES;
        }

        public static EasterBites valueOf(String str) {
            return (EasterBites) Enum.valueOf(EasterBites.class, str);
        }

        public static EasterBites[] values() {
            return (EasterBites[]) $VALUES.clone();
        }

        private EasterBites(String str, int i, int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            EasterBites[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: EmploymentScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/mrlargha/employment/center/EmploymentScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Main", "employment-center"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Navigation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Navigation[] $VALUES;
        public static final Navigation Main = new Navigation("Main", 0);

        private static final /* synthetic */ Navigation[] $values() {
            return new Navigation[]{Main};
        }

        public static EnumEntries<Navigation> getEntries() {
            return $ENTRIES;
        }

        public static Navigation valueOf(String str) {
            return (Navigation) Enum.valueOf(Navigation.class, str);
        }

        public static Navigation[] values() {
            return (Navigation[]) $VALUES.clone();
        }

        private Navigation(String str, int i) {
        }

        static {
            Navigation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: EmploymentScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/employment/center/EmploymentScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "employment-center"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.EMPLOYMENT_CENTER);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new EmploymentScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
