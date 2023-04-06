import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SupermercadoListaComponent } from './supermercados-list/super-lista.component';
import { SupermecadosFormComponent } from './supermercados-form/super-form.component';
import { SupermecadoRoutingModule } from './supermercados-routing.module';
import { SupermecadoService } from 'src/app/supermercados/supermercados.service';
import { SharedModule } from '../shared/shared.module';
import { BottonSheetConfirmaComponent } from '../shared/botton-sheet-confirma/botton-sheet-confirma.component';

@NgModule({
  declarations: [SupermercadoListaComponent, SupermecadosFormComponent],
  imports: [
    CommonModule,
    SupermecadoRoutingModule,
    SharedModule
  ],
  providers: [SupermecadoService],
  entryComponents: [BottonSheetConfirmaComponent]
})
export class SupermercadosModule { }
