import { Route, RouterModule } from '@angular/router'
import { NgModule } from '@angular/core'
import { AboutComponent } from './about/about.component';

const routes: Route[] = [
    { 
        path: 'about',
        component: AboutComponent
    }
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class StaticRoutingModule {}