import { SupermecadoModel } from '../../models/supermercado.model';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-supermecados-form',
  templateUrl: './super-form.component.html',
  styleUrls: ['./super-form.component.scss']
})
export class SupermecadosFormComponent implements OnInit {

  supermecadoForm!: FormGroup;
 supermecado: SupermecadoModel | undefined;

  supermecadoModeLMock: SupermecadoModel = 
  {
    id: 1,
    nome: 'SupermecadoSilva',
    fone: '62995635987',
    endereco:  'rua das colve'
  }

  constructor(
    private _formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.criarFormulario();
    this.editar();
  }

  criarFormulario(): void {
    this.supermecadoForm = this._formBuilder.group({
      name: ['', Validators.required],
      fone: ['', Validators.required],
      endereco: ['', Validators.required]
    })
  }

  atualizarFormulario(supermecado: SupermecadoModel) {
    this.supermecadoForm.setValue({
      name: supermecado.nome,
      fone: supermecado.fone,
      endereco: supermecado.endereco
    });
  }

  editar(): void {
    this.atualizarFormulario(this.supermecadoModeLMock);
  }

}
