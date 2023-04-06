import { Component, Optional, Inject } from '@angular/core';
import { MatBottomSheetRef, MAT_BOTTOM_SHEET_DATA } from '@angular/material/bottom-sheet'

@Component({
  selector: 'app-botton-sheet-confirma',
  templateUrl: './botton-sheet-confirma.component.html',
  styleUrls: ['./botton-sheet-confirma.component.scss']
})
export class BottonSheetConfirmaComponent {

  constructor(
    private bottonSheetRef: MatBottomSheetRef<BottonSheetConfirmaComponent>,
    @Optional()
    @Inject(MAT_BOTTOM_SHEET_DATA)
    public data: any
  ) { }

  confirmar(event: MouseEvent, b: boolean): void {
    this.bottonSheetRef.dismiss(b);
    event.preventDefault();
  }
}
