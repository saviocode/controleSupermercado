import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AboutComponent } from './about/about.component';
import { SharedModule } from '../shared/shared.module';
import { StaticRoutingModule } from './static-routing.module';
import { FeatureDetailComponent } from './about/feature-detail/feature-detail.component';

@NgModule({
  declarations: [AboutComponent, FeatureDetailComponent],
  imports: [
    CommonModule,
    SharedModule,
    StaticRoutingModule
  ]
})
export class StaticModule { }