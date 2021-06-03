import { Component, ChangeDetectionStrategy } from '@angular/core';

@Component({
  selector: 'sport-coach-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.sass'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class LoaderComponent {}
