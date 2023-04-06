import { Route, RouterModule } from '@angular/router'
import { NgModule } from '@angular/core'
import { SupermercadoListaComponent } from './supermercados-list/super-lista.component';
import { SupermecadosFormComponent } from './supermercados-form/super-form.component';

const routes: Route[] = [
    { path: '', redirectTo: 'lista' },
    { 
        path: 'lista',
        component: SupermercadoListaComponent
    },
    {
        path: 'form/editar',
        component: SupermecadosFormComponent
    }
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class SupermecadoRoutingModule {}