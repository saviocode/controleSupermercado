import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-feature-detail',
  templateUrl: './feature-detail.component.html',
  styleUrls: ['./feature-detail.component.scss']
})
export class FeatureDetailComponent implements OnInit {

  features: any [] = [
    {
    titulo: "Search Data",
    descricao: "Don’t worry if your data is very large, the Data Warehoue provides a search engine, which is useful for making it easier to find data effectively saving time.",
    imagem: "./assets/feature-detail-1.png",
    background: "rectangle-4.png"
    },
    {
      titulo: "24 Hours Access",
      descricao: "Access is given 24 hours a full morning to night and meet again in the morning, giving you comfort when you need data when urgent.",
      imagem: "./assets/feature-detail-2.png",
      background: "rectangle-3.png"
    },
    {
      titulo: "Print Out",
      descricao: "Print out service gives you convenience if someday you need print data, just edit it all and just print it.",
      imagem: "./assets/feature-detail-3.png",
      background: "rectangle-2.png"
    },
    {
      titulo: "Security Code",
      descricao: "Data Security is one of our best facilities. Allows for your files to be safer. The file can be secured with a code or password that you created, so only you can open the file.",
      imagem: "./assets/feature-detail-4.png",
      background: "rectangle-1.png"
    }
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
