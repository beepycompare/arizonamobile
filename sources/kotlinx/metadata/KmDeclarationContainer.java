package kotlinx.metadata;

import java.util.List;
import kotlin.Metadata;
/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lkotlinx/metadata/KmDeclarationContainer;", "", "functions", "", "Lkotlinx/metadata/KmFunction;", "getFunctions", "()Ljava/util/List;", "properties", "Lkotlinx/metadata/KmProperty;", "getProperties", "typeAliases", "Lkotlinx/metadata/KmTypeAlias;", "getTypeAliases", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface KmDeclarationContainer {
    List<KmFunction> getFunctions();

    List<KmProperty> getProperties();

    List<KmTypeAlias> getTypeAliases();
}
