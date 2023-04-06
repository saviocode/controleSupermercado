import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{
  path: '',
  loadChildren: () => import('./static/static.module').then(m => m.StaticModule)
},
{
  path: 'supermercados',
  loadChildren: () => import('./supermercados/supermercados.module').then(m => m.SupermercadosModule)
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
