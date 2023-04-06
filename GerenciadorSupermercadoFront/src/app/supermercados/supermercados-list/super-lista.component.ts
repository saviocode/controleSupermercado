import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { SupermecadoService } from '../supermercados.service';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatBottomSheet } from '@angular/material/bottom-sheet';
import { BottonSheetConfirmaComponent } from 'src/app/shared/botton-sheet-confirma/botton-sheet-confirma.component';

@Component({
  selector: 'app-super-lista',
  templateUrl: './super-lista.component.html',
  styleUrls: ['./super-lista.component.scss']
})
export class SupermercadoListaComponent implements OnInit {

  displayedColumns: string[] = ['nome', 'fone', 'endereco', 'editar', 'excluir'];
  dataSource = new MatTableDataSource([]);

  @ViewChild(MatPaginator)
  paginator! : MatPaginator;

  @ViewChild('paginator')
  set matPaginator(paginator: MatPaginator) {
    this.paginator = paginator;
  }

  isLoading = true;
  page = 0;
  perPage = 5;
  totalRegistros = 0;
  pageEvent: any = new PageEvent;

  constructor(
    private superService: SupermecadoService,
    private bottomSheetRef: MatBottomSheet
  ) { }

  ngOnInit(): void {
    this.listarSupermercados();
  }

  listarSupermercados(): void {
    this.isLoading = true;
    this.superService.listarSupermecado(this.page, this.perPage).subscribe(
      (res: any) => {
        this.dataSource.data = res.results;
        this.totalRegistros = res.results.length;
        this.dataSource.paginator = this.paginator;
        this.isLoading = false;
      }, error => (this.isLoading = false)
    );
  }

  pageChanged(event: Event):void {
    if (event) {
      this.perPage = event.eventPhase;
      this.page = event.eventPhase;
    }
    this.listarSupermercados();
  }

  confirmarExclusao(): void {
    this.bottomSheetRef.open(BottonSheetConfirmaComponent).afterDismissed()
    .subscribe((confirmaExclusao: boolean) => {
      if (confirmaExclusao) {
        this.bottomSheetRef.dismiss();
      }
    })
  }
}
