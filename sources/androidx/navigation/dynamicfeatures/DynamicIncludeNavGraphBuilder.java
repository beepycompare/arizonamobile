package androidx.navigation.dynamicfeatures;

import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.NavType;
import androidx.navigation.dynamicfeatures.DynamicIncludeGraphNavigator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
/* compiled from: DynamicIncludeNavGraphBuilder.kt */
@NavDestinationDsl
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\rBJ\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000e\u0012\u001b\u0010\u000f\u001a\u0017\u0012\u0004\u0012\u00020\u0011\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0012¢\u0006\u0002\b\u00130\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u0014J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/navigation/dynamicfeatures/DynamicIncludeNavGraphBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/dynamicfeatures/DynamicIncludeGraphNavigator$DynamicIncludeNavGraph;", "dynamicIncludeGraphNavigator", "Landroidx/navigation/dynamicfeatures/DynamicIncludeGraphNavigator;", "id", "", "moduleName", "", "graphResourceName", "<init>", "(Landroidx/navigation/dynamicfeatures/DynamicIncludeGraphNavigator;ILjava/lang/String;Ljava/lang/String;)V", "route", "(Landroidx/navigation/dynamicfeatures/DynamicIncludeGraphNavigator;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lkotlin/reflect/KClass;", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Landroidx/navigation/dynamicfeatures/DynamicIncludeGraphNavigator;Lkotlin/reflect/KClass;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "graphPackage", "getGraphPackage", "()Ljava/lang/String;", "setGraphPackage", "(Ljava/lang/String;)V", "build", "navigation-dynamic-features-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DynamicIncludeNavGraphBuilder extends NavDestinationBuilder<DynamicIncludeGraphNavigator.DynamicIncludeNavGraph> {
    private DynamicIncludeGraphNavigator dynamicIncludeGraphNavigator;
    private String graphPackage;
    private String graphResourceName;
    private String moduleName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use routes to create your DynamicIncludeNavGraphBuilder instead", replaceWith = @ReplaceWith(expression = "DynamicIncludeNavGraphBuilder(dynamicIncludeGraphNavigator, route = id.toString(), moduleName, graphResourceName)", imports = {}))
    public DynamicIncludeNavGraphBuilder(DynamicIncludeGraphNavigator dynamicIncludeGraphNavigator, int i, String moduleName, String graphResourceName) {
        super(dynamicIncludeGraphNavigator, i);
        Intrinsics.checkNotNullParameter(dynamicIncludeGraphNavigator, "dynamicIncludeGraphNavigator");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        this.dynamicIncludeGraphNavigator = dynamicIncludeGraphNavigator;
        this.moduleName = moduleName;
        this.graphResourceName = graphResourceName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicIncludeNavGraphBuilder(DynamicIncludeGraphNavigator dynamicIncludeGraphNavigator, String route, String moduleName, String graphResourceName) {
        super(dynamicIncludeGraphNavigator, route);
        Intrinsics.checkNotNullParameter(dynamicIncludeGraphNavigator, "dynamicIncludeGraphNavigator");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        this.dynamicIncludeGraphNavigator = dynamicIncludeGraphNavigator;
        this.moduleName = moduleName;
        this.graphResourceName = graphResourceName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicIncludeNavGraphBuilder(DynamicIncludeGraphNavigator dynamicIncludeGraphNavigator, KClass<?> route, Map<KType, NavType<?>> typeMap, String moduleName, String graphResourceName) {
        super(dynamicIncludeGraphNavigator, route, typeMap);
        Intrinsics.checkNotNullParameter(dynamicIncludeGraphNavigator, "dynamicIncludeGraphNavigator");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(graphResourceName, "graphResourceName");
        this.dynamicIncludeGraphNavigator = dynamicIncludeGraphNavigator;
        this.moduleName = moduleName;
        this.graphResourceName = graphResourceName;
    }

    public final String getGraphPackage() {
        return this.graphPackage;
    }

    public final void setGraphPackage(String str) {
        this.graphPackage = str;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public DynamicIncludeGraphNavigator.DynamicIncludeNavGraph build() {
        DynamicIncludeGraphNavigator.DynamicIncludeNavGraph dynamicIncludeNavGraph = (DynamicIncludeGraphNavigator.DynamicIncludeNavGraph) super.build();
        if (this.moduleName.length() <= 0) {
            throw new IllegalStateException("Module name cannot be empty".toString());
        }
        dynamicIncludeNavGraph.setModuleName(this.moduleName);
        String str = this.graphPackage;
        if (str == null) {
            dynamicIncludeNavGraph.setGraphPackage(this.dynamicIncludeGraphNavigator.getPackageName$navigation_dynamic_features_runtime_release() + '.' + this.moduleName);
        } else {
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                throw new IllegalStateException("Graph package name cannot be empty".toString());
            }
            dynamicIncludeNavGraph.setGraphPackage(this.graphPackage);
        }
        if (this.graphResourceName.length() <= 0) {
            throw new IllegalStateException("Graph resource name cannot be empty".toString());
        }
        dynamicIncludeNavGraph.setGraphResourceName(this.graphResourceName);
        return dynamicIncludeNavGraph;
    }
}
