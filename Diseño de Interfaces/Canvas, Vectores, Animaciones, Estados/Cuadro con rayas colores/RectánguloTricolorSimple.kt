package com.example.segundaevaluacion2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.appcompat.widget.AppCompatButton

class RectánguloTricolorSimple(context: Context?) : AppCompatButton(context)
{
    var paint: Paint = Paint()
    override fun onDraw(canvas: Canvas)
    {
        paint.color = Color.GREEN
        canvas.drawRect(30F, 10F, 1050F, 100F, paint)
        paint.color = Color.BLUE
        canvas.drawRect(30F, 40F, 1050F, 100F, paint)
        paint.color = Color.RED
        canvas.drawRect(30F, 70F, 1050F, 100F, paint)

        paint.color = Color.GREEN
        canvas.drawRect(30F, 10F, 100F, 1450F, paint)
        paint.color = Color.BLUE
        canvas.drawRect(60F, 40F, 100F, 1450F, paint)
        paint.color = Color.RED
        canvas.drawRect(130F, 70F, 100F, 1450F, paint)

        paint.color = Color.GREEN
        canvas.drawRect(950F, 10F, 1060F, 1450F, paint)
        paint.color = Color.BLUE
        canvas.drawRect(950F, 40F, 1030F, 1450F, paint)
        paint.color = Color.RED
        canvas.drawRect(950F, 70F, 990F, 1450F, paint)

        paint.color = Color.GREEN
        canvas.drawRect(30F, 1420F, 1050F, 1450F, paint)
        paint.color = Color.BLUE
        canvas.drawRect(60F, 1420F, 1030F, 1380F, paint)
        paint.color = Color.RED
        canvas.drawRect(100F, 1350F, 990F, 1380F, paint)

        paint.color = Color.MAGENTA
        canvas.drawRect(30F, 10F, 130F, 100F, paint)

        paint.color = Color.MAGENTA
        canvas.drawRect(950F, 10F, 1060F, 100F, paint)

        paint.color = Color.MAGENTA
        canvas.drawRect(950F, 1350F, 1060F, 1450F, paint)

        paint.color = Color.MAGENTA
        canvas.drawRect(30F, 1350F, 130F, 1450F, paint)
    }
}