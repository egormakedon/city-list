import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CityEditComponent } from './component/city-edit/city-edit.component';
import { MainComponent } from './component/main/main.component';

const routes: Routes = [
  { path: '', component: MainComponent },
  { path: 'edit/city/:id', component: CityEditComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
