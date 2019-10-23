import { Component, OnInit } from '@angular/core';
import {Chart} from 'chart.js'
@Component({
 selector: 'app-histo',
 templateUrl: './histo.component.html',
 styleUrls: ['./histo.component.css']
})
export class HistoComponent implements OnInit {
 BarChart = [];
 constructor() { }
 ngOnInit(){
 this.BarChart = new Chart('barChart', {
   type: 'bar',
   data: {
     labels:["Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"],
     datasets: [
       {
         label: 'Nombre de transactions',
         data: [5,10,15,20,25,30]  ,
         borderColor: '#3cba9f',
         backgroundColor: [
          "Gray",
          "Green" ,
          "Gray",
          "Green" ,
          "Gray",
          "Green" ,
         ],
         fill: true
       }
     ]
   },
   options: {
     legend: {
       display: false
     },
     scales: {
       xAxes: [{
         display: true
       }],
       yAxes: [{
         display: true ,
         ticks:{
           beginAtZero:true
         }
       }],
     }
   }
 });
};
 }