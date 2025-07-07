package com.androidplot.xy;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.SeriesBundle;
import com.androidplot.ui.Size;
import com.androidplot.ui.TableModel;
import com.androidplot.ui.widget.LegendWidget;
import com.androidplot.xy.XYLegendItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class XYLegendWidget extends LegendWidget<XYLegendItem> {
    private XYPlot plot;

    public XYLegendWidget(LayoutManager layoutManager, XYPlot xYPlot, Size size, TableModel tableModel, Size size2) {
        super(tableModel, layoutManager, size, size2);
        this.plot = xYPlot;
        setLegendItemComparator(new Comparator<XYLegendItem>() { // from class: com.androidplot.xy.XYLegendWidget.1
            @Override // java.util.Comparator
            public int compare(XYLegendItem xYLegendItem, XYLegendItem xYLegendItem2) {
                if (xYLegendItem.type == xYLegendItem2.type) {
                    return xYLegendItem.getTitle().compareTo(xYLegendItem2.getTitle());
                }
                return xYLegendItem.type.compareTo(xYLegendItem2.type);
            }
        });
    }

    protected void drawRegionLegendIcon(Canvas canvas, RectF rectF, XYRegionFormatter xYRegionFormatter) {
        canvas.drawRect(rectF, xYRegionFormatter.getPaint());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.androidplot.xy.XYLegendWidget$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$xy$XYLegendItem$Type;

        static {
            int[] iArr = new int[XYLegendItem.Type.values().length];
            $SwitchMap$com$androidplot$xy$XYLegendItem$Type = iArr;
            try {
                iArr[XYLegendItem.Type.REGION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$androidplot$xy$XYLegendItem$Type[XYLegendItem.Type.SERIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.androidplot.ui.widget.LegendWidget
    public void drawIcon(Canvas canvas, RectF rectF, XYLegendItem xYLegendItem) {
        int i = AnonymousClass2.$SwitchMap$com$androidplot$xy$XYLegendItem$Type[xYLegendItem.type.ordinal()];
        if (i == 1) {
            drawRegionLegendIcon(canvas, rectF, (XYRegionFormatter) xYLegendItem.item);
        } else if (i == 2) {
            XYSeriesFormatter xYSeriesFormatter = (XYSeriesFormatter) xYLegendItem.item;
            ((XYSeriesRenderer) this.plot.getRenderer(xYSeriesFormatter.getRendererClass())).drawSeriesLegendIcon(canvas, rectF, xYSeriesFormatter);
        } else {
            throw new UnsupportedOperationException("Unexpected item type: " + xYLegendItem.type);
        }
    }

    @Override // com.androidplot.ui.widget.LegendWidget
    protected List<XYLegendItem> getLegendItems() {
        ArrayList arrayList = new ArrayList();
        for (SeriesBundle<XYSeries, XYSeriesFormatter> seriesBundle : this.plot.getRegistry().getLegendEnabledItems()) {
            arrayList.add(new XYLegendItem(XYLegendItem.Type.SERIES, seriesBundle.getFormatter(), seriesBundle.getSeries().getTitle()));
        }
        for (XYSeriesRenderer xYSeriesRenderer : this.plot.getRendererList()) {
            for (Map.Entry<XYRegionFormatter, String> entry : xYSeriesRenderer.getUniqueRegionFormatters().entrySet()) {
                arrayList.add(new XYLegendItem(XYLegendItem.Type.REGION, entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }
}
