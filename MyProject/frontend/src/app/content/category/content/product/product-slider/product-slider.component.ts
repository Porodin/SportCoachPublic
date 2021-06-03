import {
  Component,
  Input,
  ChangeDetectorRef,
  ChangeDetectionStrategy,
} from '@angular/core';
import { IProductImage } from '@product-store/reducers/product.reducer';
import {
  Slider,
  slideAnimation,
  initSliderAnimation,
} from '@shared/utils/slider';
@Component({
  selector: 'sport-coach-product-slider',
  templateUrl: './product-slider.component.html',
  animations: [slideAnimation, initSliderAnimation],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProductSliderComponent extends Slider<IProductImage> {
  @Input()
  public items: IProductImage[] = [];

  constructor(_cdr: ChangeDetectorRef) {
    super(_cdr);
  }
}
